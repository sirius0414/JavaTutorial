package org.siyue.leetcode;

import org.siyue.leetcode.stack.lc20;

import java.util.*;

public class lc2977 {
    public static void main(String[] args) throws InterruptedException {
        lc2977.Solution solution = new lc2977.Solution();

    }

    /**
     * 使用 Dijkstra + DP（不使用 AC 自动机）
     * 枚举区间方式：按长度分组 + Rolling Hash（64-bit，溢出即模 2^64）来匹配 source 的 original 子串
     *
     * 方法签名符合你给的：
     *   public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost)
     */
    public static class Solution {

        // 一个足够大的 INF，用 long 防溢出
        private static final long INF = Long.MAX_VALUE / 4;

        // -----------------------------
        // 图边
        // -----------------------------
        static class Edge {
            int to;
            int w;
            Edge(int to, int w) { this.to = to; this.w = w; }
        }

        // -----------------------------
        // Dijkstra：非负权最短路（从 src 到所有点）
        // -----------------------------
        private static long[] dijkstra(List<Edge>[] adj, int src) {
            int n = adj.length;
            long[] dist = new long[n];
            Arrays.fill(dist, INF);
            dist[src] = 0;

            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
            pq.add(new long[]{0L, src});

            while (!pq.isEmpty()) {
                long[] cur = pq.poll();
                long d = cur[0];
                int v = (int) cur[1];
                if (d != dist[v]) continue;

                for (Edge e : adj[v]) {
                    long nd = d + e.w;
                    if (nd < dist[e.to]) {
                        dist[e.to] = nd;
                        pq.add(new long[]{nd, e.to});
                    }
                }
            }
            return dist;
        }

        // -----------------------------
        // 64-bit Rolling Hash：利用 long 溢出（等价 mod 2^64）
        // -----------------------------
        static class RH64 {
            final long base;
            final long[] pref; // 前缀 hash
            final long[] pow;  // base^k

            RH64(String s, long base) {
                this.base = base;
                int n = s.length();
                pref = new long[n + 1];
                pow  = new long[n + 1];
                pow[0] = 1L;
                for (int i = 0; i < n; i++) {
                    int x = (s.charAt(i) - 'a' + 1); // a->1..z->26
                    pref[i + 1] = pref[i] * base + x;  // 溢出即 mod 2^64
                    pow[i + 1]  = pow[i] * base;
                }
            }

            // 返回 s[l..r) 的 hash
            long subHash(int l, int r) {
                return pref[r] - pref[l] * pow[r - l];
            }
        }

        // -----------------------------
        // 小型 int 动态数组（避免大量装箱）
        // -----------------------------
        static class IntList {
            int[] a = new int[4];
            int sz = 0;
            void add(int v) {
                if (sz == a.length) a = Arrays.copyOf(a, a.length << 1);
                a[sz++] = v;
            }
            int size() { return sz; }
            int get(int i) { return a[i]; }
        }

        // original 匹配条目：保存原串 + 对应图节点 id（用于作为最短路起点）
        static class OrigEntry {
            String s;
            int nodeId;
            OrigEntry(String s, int nodeId) { this.s = s; this.nodeId = nodeId; }
        }

        public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
            int n = source.length();
            int m = original.length;

            // -----------------------------
            // 1) 字符串节点编号：unique(original ∪ changed)
            // -----------------------------
            HashMap<String, Integer> id = new HashMap<>();
            ArrayList<String> dict = new ArrayList<>();

            // 获取/创建节点 id
            java.util.function.Function<String, Integer> getId = s -> {
                Integer v = id.get(s);
                if (v != null) return v;
                int nid = dict.size();
                dict.add(s);
                id.put(s, nid);
                return nid;
            };

            int[] oId = new int[m];
            int[] cId = new int[m];
            for (int i = 0; i < m; i++) {
                oId[i] = getId.apply(original[i]);
                cId[i] = getId.apply(changed[i]);
            }
            int V = dict.size();

            // -----------------------------
            // 2) 建图：original -> changed，边权为 cost
            //    注意同一对 (u,v) 可能重复，保留最小 cost
            // -----------------------------
            HashMap<Long, Integer> best = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int u = oId[i], v = cId[i], w = cost[i];
                long key = (((long) u) << 32) ^ (v & 0xffffffffL);
                Integer prev = best.get(key);
                if (prev == null || w < prev) best.put(key, w);
            }

            @SuppressWarnings("unchecked")
            List<Edge>[] adj = new ArrayList[V];
            for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
            for (Map.Entry<Long, Integer> e : best.entrySet()) {
                long key = e.getKey();
                int u = (int) (key >>> 32);
                int v = (int) (key & 0xffffffffL);
                adj[u].add(new Edge(v, e.getValue()));
            }

            // -----------------------------
            // 3) 只对 unique(original 节点) 跑 Dijkstra
            //    因为 DP 查询的左边 x 必须是某个 original 出现在 source 中的子串
            // -----------------------------
            int[] uniqOrigNodes = Arrays.stream(oId).distinct().toArray();
            HashMap<Integer, long[]> distFrom = new HashMap<>(uniqOrigNodes.length * 2);
            for (int s : uniqOrigNodes) {
                distFrom.put(s, dijkstra(adj, s));
            }

            // -----------------------------
            // 4) 准备 Rolling Hash：source / target
            // -----------------------------
            final long BASE = 911382323L; // 固定 base
            RH64 rhS = new RH64(source, BASE);
            RH64 rhT = new RH64(target, BASE);

            // -----------------------------
            // 5) 按长度分组：original 的匹配桶
            //    mapOrigByLen[L][hash] -> 可能的 original 条目索引列表（碰撞时再 regionMatches 校验）
            // -----------------------------
            ArrayList<OrigEntry> origEntries = new ArrayList<>();
            // 去重：同一个 original 字符串只需要保留一次即可（因为作为“起点字符串”其节点 id 唯一）
            HashSet<String> seenOrigStr = new HashSet<>();
            for (int i = 0; i < m; i++) {
                String o = original[i];
                if (seenOrigStr.add(o)) {
                    origEntries.add(new OrigEntry(o, id.get(o)));
                }
            }

            HashMap<Integer, HashMap<Long, IntList>> mapOrigByLen = new HashMap<>();
            HashSet<Integer> lensSet = new HashSet<>();
            for (int idx = 0; idx < origEntries.size(); idx++) {
                OrigEntry e = origEntries.get(idx);
                int L = e.s.length();
                lensSet.add(L);
                long h = new RH64(e.s, BASE).subHash(0, L); // 原串 hash
                mapOrigByLen
                        .computeIfAbsent(L, __ -> new HashMap<>())
                        .computeIfAbsent(h, __ -> new IntList())
                        .add(idx); // 保存条目索引
            }

            // 所有可能的长度（升序），DP 时遍历这些 L
            int[] lens = lensSet.stream().mapToInt(x -> x).toArray();
            Arrays.sort(lens);

            // -----------------------------
            // 6) 目标子串 y 必须是“字典节点”之一（original ∪ changed）
            //    mapDictByLen[L][hash] -> 候选 dict nodeId 列表，碰撞时再 regionMatches 校验
            // -----------------------------
            HashMap<Integer, HashMap<Long, IntList>> mapDictByLen = new HashMap<>();
            for (int nodeId = 0; nodeId < dict.size(); nodeId++) {
                String s = dict.get(nodeId);
                int L = s.length();
                long h = new RH64(s, BASE).subHash(0, L);
                mapDictByLen
                        .computeIfAbsent(L, __ -> new HashMap<>())
                        .computeIfAbsent(h, __ -> new IntList())
                        .add(nodeId);
            }

            // target[i..i+L) 若恰好是 dict 中某个字符串，返回其 nodeId，否则返回 null
            java.util.function.BiFunction<Integer, Integer, Integer> lookupTargetNodeId = (i, L) -> {
                int j = i + L;
                if (j > n) return null;
                HashMap<Long, IntList> bucket = mapDictByLen.get(L);
                if (bucket == null) return null;

                long h = rhT.subHash(i, j);
                IntList cands = bucket.get(h);
                if (cands == null) return null;

                // 为了严谨：hash 命中后用 regionMatches 校验（避免极小概率碰撞）
                for (int t = 0; t < cands.size(); t++) {
                    int nodeId = cands.get(t);
                    String ds = dict.get(nodeId);
                    if (ds.regionMatches(0, target, i, L)) return nodeId;
                }
                return null;
            };

            // -----------------------------
            // 7) DP：dp[i] 表示把 source[0..i) 变成 target[0..i) 的最小成本
            // -----------------------------
            long[] dp = new long[n + 1];
            Arrays.fill(dp, INF);
            dp[0] = 0;

            for (int i = 0; i < n; i++) {
                if (dp[i] >= INF) continue;

                // 方案1：当前位置不替换（字符必须相同）
                if (source.charAt(i) == target.charAt(i)) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[i]);
                }

                // 方案2：替换一个区间 [i, i+L)，L 只能取 original 中出现过的长度
                for (int L : lens) {
                    int j = i + L;
                    if (j > n) break;

                    // 2.1 先看 source[i..j) 是否匹配某个 original（用 hash 找桶）
                    HashMap<Long, IntList> bucket = mapOrigByLen.get(L);
                    if (bucket == null) continue;

                    long hs = rhS.subHash(i, j);
                    IntList entryIdxs = bucket.get(hs);
                    if (entryIdxs == null) continue;

                    // 2.2 target 对应区间 y = target[i..j) 必须在字典节点中
                    Integer yNode = lookupTargetNodeId.apply(i, L);
                    if (yNode == null) continue;

                    // 2.3 对于桶内的每个 original 候选，做 regionMatches 校验后尝试 DP 转移
                    for (int t = 0; t < entryIdxs.size(); t++) {
                        OrigEntry oe = origEntries.get(entryIdxs.get(t));
                        // 校验 source 的这段确实等于 original 字符串（防止 hash 碰撞）
                        if (!oe.s.regionMatches(0, source, i, L)) continue;

                        // dist[x][y]：从 x(=original) 到 y(=target 子串) 的最小成本
                        long[] dist = distFrom.get(oe.nodeId);
                        long w = (dist == null) ? INF : dist[yNode];
                        if (w >= INF) continue; // 到不了

                        dp[j] = Math.min(dp[j], dp[i] + w);
                    }
                }
            }

            return (dp[n] >= INF) ? -1L : dp[n];
        }
    }



}
