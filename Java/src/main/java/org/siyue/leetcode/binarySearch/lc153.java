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
            int l = 0;
            int r = nums.length - 1;


            while (r > l) {
                int mid = (l + r) / 2;
                int midVal = nums[mid];

                // 不能用 nums[mid] 和 nums[l] 作为稳定判据。
                // nums[mid] > nums[l] 只能说明左半段有序，
                // 但不能保证每一步都能安全剪枝。
                // 特别是当区间缩小到 mid == l 时，这个比较会失效，可能误删最小值。
                // 因此这题应比较 nums[mid] 和 nums[r]。

                // 反例：nums = 【1，2，3，4，5】
                // 此时mid大于left，小于right
                // 和右边比扔掉右边，向左收缩，对的
                // 和左边比扔掉左边，向右收缩，错的
                if  (midVal > nums[r]) {
                    // left side has orders, shrink right
                    l = mid + 1;
                } else {
                    // right side has orders, shrink left
                    r = mid;
                }
            }

            return nums[l];
        }
    }
}
