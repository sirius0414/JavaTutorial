package org.siyue.leetcode;

public class lc300 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = solution.lengthOfLIS(nums);
        System.out.println(result);
        
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int result2 = solution.lengthOfLIS(nums2);
        System.out.println(result2);
        
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        int result3 = solution.lengthOfLIS(nums3);
        System.out.println(result3);
    }

    static class Solution {
        public int lengthOfLIS(int[] nums) {
            // TODO: 实现方法
            return 0;
        }
    }
}
