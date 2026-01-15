package org.siyue.leetcode;

public class lc41 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 2, 0};
        int result = solution.firstMissingPositive(nums);
        System.out.println(result);
        
        int[] nums2 = {3, 4, -1, 1};
        int result2 = solution.firstMissingPositive(nums2);
        System.out.println(result2);
        
        int[] nums3 = {7, 8, 9, 11, 12};
        int result3 = solution.firstMissingPositive(nums3);
        System.out.println(result3);
    }

    static class Solution {
        public int firstMissingPositive(int[] nums) {
            // TODO: 实现方法
            return 0;
        }
    }
}
