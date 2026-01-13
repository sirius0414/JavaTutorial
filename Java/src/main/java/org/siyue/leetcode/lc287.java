package org.siyue.leetcode;

public class lc287 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 3, 4, 2, 2};
        int result = solution.findDuplicate(nums);
        System.out.println(result);
        
        int[] nums2 = {3, 1, 3, 4, 2};
        int result2 = solution.findDuplicate(nums2);
        System.out.println(result2);
    }

    static class Solution {
        public int findDuplicate(int[] nums) {
            // TODO: 实现方法
            return 0;
        }
    }
}
