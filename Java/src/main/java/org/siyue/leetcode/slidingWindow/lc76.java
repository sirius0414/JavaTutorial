package org.siyue.leetcode.slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class lc76 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();

    }

    static class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) return "";

            Map<Character, Integer> need = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            Map<Character, Integer> window = new HashMap<>();
            int required = need.size();
            int formed = 0;

            int l = 0;
            int bestLen = Integer.MAX_VALUE;
            int bestL = 0;

            for (int r = 0; r < s.length(); r++) {
                char c = s.charAt(r);

                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).intValue() == need.get(c).intValue()) {
                        formed++;
                    }
                }

                // 收缩窗口：只要已经满足，就尽量缩小
                while (formed == required && l <= r) {
                    if (r - l + 1 < bestLen) {
                        bestLen = r - l + 1;
                        bestL = l;
                    }

                    char left = s.charAt(l);
                    if (need.containsKey(left)) {
                        window.put(left, window.get(left) - 1);
                        if (window.get(left) < need.get(left)) {
                            formed--;
                        }
                        if (window.get(left) == 0) window.remove(left);
                    }
                    l++;
                }
            }

            return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestL, bestL + bestLen);
        }
    }

}
