package org.siyue.leetcode.dp;

public class lc152 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {2, 3, -2, 4};
        int result = solution.maxProduct(nums);
        System.out.println(result);
        
        int[] nums2 = {-2, 0, -1};
        int result2 = solution.maxProduct(nums2);
        System.out.println(result2);
    }

    static class Solution {
        public int maxProduct(int[] nums) {
            // TODO: 实现方法
            return 0;
        }
    }
}
