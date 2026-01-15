package org.siyue.leetcode.arrayHash;

import java.util.*;

public class lc128 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();

    }

    static class Solution {
        public int longestConsecutive(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int longestStreak = 0;
            for (int num : map.keySet()) {
                if (!map.containsKey(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    while (map.containsKey(currentNum + 1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }
    }

}

