package org.siyue.leetcode.binarySearch;

import java.util.Arrays;

public class lc34 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println(Arrays.toString(result));
        
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println(Arrays.toString(result2));
        
        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = solution.searchRange(nums3, target3);
        System.out.println(Arrays.toString(result3));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = lowerBound(nums, target);       // 第一个 >= target 的位置
            int right = lowerBound(nums, target + 1) - 1; // 第一个 >= target+1 的位置，再减 1

            if (left == nums.length || nums[left] != target) {
                return new int[]{-1, -1};
            }

            return new int[]{left, right};
        }

        // 返回第一个 >= target 的下标
        private int lowerBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length; // 注意：右边界开区间

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }
}
