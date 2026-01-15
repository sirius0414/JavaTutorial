package org.siyue.leetcode.binarySearch;

public class lc33 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = solution.search(nums, target);
        System.out.println(result);
        
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        int result2 = solution.search(nums2, target2);
        System.out.println(result2);
        
        int[] nums3 = {1};
        int target3 = 0;
        int result3 = solution.search(nums3, target3);
        System.out.println(result3);
    }

    static class Solution {
        public int search(int[] nums, int target) {
            // TODO: 实现方法
            return -1;
        }
    }
}
