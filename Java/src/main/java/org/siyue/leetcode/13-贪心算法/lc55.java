package org.siyue.leetcode;

public class lc55 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {2, 3, 1, 1, 4};
        boolean result = solution.canJump(nums);
        System.out.println(result);
        
        int[] nums2 = {3, 2, 1, 0, 4};
        boolean result2 = solution.canJump(nums2);
        System.out.println(result2);
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            // TODO: 实现方法
            return false;
        }
    }
}
