package org.siyue.leetcode;

public class lc35 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int result = solution.searchInsert(nums, target);
        System.out.println(result);
        
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        int result2 = solution.searchInsert(nums2, target2);
        System.out.println(result2);
        
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        int result3 = solution.searchInsert(nums3, target3);
        System.out.println(result3);
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            // TODO: 实现方法
            return 0;
        }
    }
}
