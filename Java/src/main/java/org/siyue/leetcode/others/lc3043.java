package org.siyue.leetcode.others;

import java.util.HashSet;
import java.util.Set;

public class lc3043 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};
        int result = solution.longestCommonPrefix(arr1, arr2);
        System.out.println(result);
    }

    static class Solution {
        public int longestCommonPrefix(int[] arr1, int[] arr2) {
            Set<Integer> set = new HashSet<>();

            for (int num : arr1) {
                while (num > 0) {
                    set.add(num);
                    num /= 10;
                }
            }

            int ans = 0;

            for (int num : arr2) {
                while (num > 0) {
                    if (set.contains(num)) {
                        ans = Math.max(ans, digitLength(num));
                    }
                    num /= 10;
                }
            }

            return ans;
        }

        private int digitLength(int num) {
            int len = 0;
            while (num > 0) {
                len++;
                num /= 10;
            }
            return len;
        }
    }
}
