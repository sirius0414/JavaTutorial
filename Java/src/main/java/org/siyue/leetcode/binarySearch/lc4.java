package org.siyue.leetcode.binarySearch;

public class lc4 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
        
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        double result2 = solution.findMedianSortedArrays(nums3, nums4);
        System.out.println(result2);
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // TODO: 实现方法
            return 0.0;
        }
    }
}
