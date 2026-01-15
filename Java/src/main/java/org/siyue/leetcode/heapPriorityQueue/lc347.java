package org.siyue.leetcode;

import java.util.Arrays;

public class lc347 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
        
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.topKFrequent(nums2, k2);
        System.out.println(Arrays.toString(result2));
    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // TODO: 实现方法
            return new int[0];
        }
    }
}
