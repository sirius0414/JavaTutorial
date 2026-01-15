package org.siyue.leetcode.dp;

public class lc198 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1};
        int result = solution.rob(nums);
        System.out.println(result);
        
        int[] nums2 = {2, 7, 9, 3, 1};
        int result2 = solution.rob(nums2);
        System.out.println(result2);
    }

    static class Solution {
        public int rob(int[] nums) {
            // TODO: 实现方法
            return 0;
        }
    }
}
