package org.siyue.leetcode.binarySearch;

import java.util.Arrays;

public class lc34 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println(Arrays.toString(result));
        
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println(Arrays.toString(result2));
        
        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = solution.searchRange(nums3, target3);
        System.out.println(Arrays.toString(result3));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            // TODO: 实现方法
            return new int[0];
        }
    }
}
