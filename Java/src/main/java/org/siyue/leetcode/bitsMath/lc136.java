package org.siyue.leetcode.bitsMath;

public class lc136 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {2, 2, 1};
        int result = solution.singleNumber(nums);
        System.out.println(result);
        
        int[] nums2 = {4, 1, 2, 1, 2};
        int result2 = solution.singleNumber(nums2);
        System.out.println(result2);
        
        int[] nums3 = {1};
        int result3 = solution.singleNumber(nums3);
        System.out.println(result3);
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            // TODO: 实现方法
            return 0;
        }
    }
}
