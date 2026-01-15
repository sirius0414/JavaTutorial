package org.siyue.leetcode.binarySearch;

public class lc153 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {3, 4, 5, 1, 2};
        int result = solution.findMin(nums);
        System.out.println(result);
        
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int result2 = solution.findMin(nums2);
        System.out.println(result2);
        
        int[] nums3 = {11, 13, 15, 17};
        int result3 = solution.findMin(nums3);
        System.out.println(result3);
    }

    static class Solution {
        public int findMin(int[] nums) {
            // TODO: 实现方法
            return 0;
        }
    }
}
