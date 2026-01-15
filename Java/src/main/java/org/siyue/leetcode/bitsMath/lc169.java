package org.siyue.leetcode.bitsMath;

public class lc169 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {3, 2, 3};
        int result = solution.majorityElement(nums);
        System.out.println(result);
        
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int result2 = solution.majorityElement(nums2);
        System.out.println(result2);
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            // TODO: 实现方法
            return 0;
        }
    }
}
