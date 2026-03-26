package org.siyue.leetcode.binarySearch;

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
            int left = 0;
            int right = nums.length - 1;

            if (target <= nums[0]) {
                return 0;
            }

            if (target > nums[right]) {
                return nums.length;
            }

            while (right - left > 1) {
                int midIndex = (left + right) / 2;
                int midVal = nums[midIndex];
                if (target == midVal) {
                    return midIndex;
                } else if (target < midVal) {
                    // 在左侧，right收缩
                    right = midIndex;
                } else if (target > midVal) {
                    left = midIndex;
                }
            }

            if (nums[right] == target) {
                return right;
            }

            return right;
        }
    }
}
