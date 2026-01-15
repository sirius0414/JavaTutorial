package org.siyue.leetcode;

public class lc416 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 5, 11, 5};
        boolean result = solution.canPartition(nums);
        System.out.println(result);
        
        int[] nums2 = {1, 2, 3, 5};
        boolean result2 = solution.canPartition(nums2);
        System.out.println(result2);
    }

    static class Solution {
        public boolean canPartition(int[] nums) {
            // TODO: 实现方法
            return false;
        }
    }
}
