package org.siyue.leetcode;

public class lc45 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {2, 3, 1, 1, 4};
        int result = solution.jump(nums);
        System.out.println(result);
        
        int[] nums2 = {2, 3, 0, 1, 4};
        int result2 = solution.jump(nums2);
        System.out.println(result2);
    }

    static class Solution {
        public int jump(int[] nums) {
            // TODO: 实现方法
            return 0;
        }
    }
}
