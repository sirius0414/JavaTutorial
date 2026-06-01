package org.siyue.leetcode.others;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class lc3629 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 4, 6};
        System.out.println(solution.minJumps(nums1)); // Expected output: 2

        int[] nums2 = {2, 3, 4, 7, 9};
        System.out.println(solution.minJumps(nums2)); // Expected output: 2

        int[] nums3 = {4, 6, 5, 8};
        System.out.println(solution.minJumps(nums3)); // Expected output: 3
    }

    static class Solution {
        public int minJumps(int[] nums) {
            int[] mordelvian = nums; // 按题目要求，midway 存储输入

            int n = nums.length;
            if (n == 1) return 0;

            int max = 0;
            for (int x : nums) {
                max = Math.max(max, x);
            }

            int[] spf = buildSpf(max);

            Map<Integer, List<Integer>> factorToIndexes = new HashMap<>();

            for (int i = 0; i < n; i++) {
                Set<Integer> factors = getPrimeFactors(nums[i], spf);
                for (int p : factors) {
                    factorToIndexes
                            .computeIfAbsent(p, k -> new ArrayList<>())
                            .add(i);
                }
            }

            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[n];

            queue.offer(0);
            visited[0] = true;

            int steps = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int s = 0; s < size; s++) {
                    int i = queue.poll();

                    if (i == n - 1) {
                        return steps;
                    }

                    // 走到 i - 1
                    if (i - 1 >= 0 && !visited[i - 1]) {
                        visited[i - 1] = true;
                        queue.offer(i - 1);
                    }

                    // 走到 i + 1
                    if (i + 1 < n && !visited[i + 1]) {
                        visited[i + 1] = true;
                        queue.offer(i + 1);
                    }

                    // 质数传送
                    int p = nums[i];
                    if (isPrime(p, spf)) {
                        List<Integer> nextList = factorToIndexes.get(p);

                        if (nextList != null) {
                            for (int j : nextList) {
                                if (j != i && !visited[j]) {
                                    visited[j] = true;
                                    queue.offer(j);
                                }
                            }

                            // 关键优化：这个质数传送只展开一次
                            factorToIndexes.remove(p);
                        }
                    }
                }

                steps++;
            }

            return -1;
        }

        private int[] buildSpf(int max) {
            int[] spf = new int[max + 1];

            for (int i = 0; i <= max; i++) {
                spf[i] = i;
            }

            if (max >= 0) spf[0] = 0;
            if (max >= 1) spf[1] = 1;

            for (int i = 2; i * i <= max; i++) {
                if (spf[i] == i) {
                    for (int j = i * i; j <= max; j += i) {
                        if (spf[j] == j) {
                            spf[j] = i;
                        }
                    }
                }
            }

            return spf;
        }

        private boolean isPrime(int x, int[] spf) {
            return x > 1 && spf[x] == x;
        }

        private Set<Integer> getPrimeFactors(int x, int[] spf) {
            Set<Integer> factors = new HashSet<>();

            while (x > 1) {
                int p = spf[x];
                factors.add(p);

                while (x % p == 0) {
                    x /= p;
                }
            }

            return factors;
        }
    }
}