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
            int l1, r1;
            int l2, r2;

            l1 = 0;
            l2 = 0;
            r1 = nums1.length;
            r2 = nums2.length;


            while (l1 < r1 && l2 < r2) {
                // do binary search for two nums:
                int m1 = (l1 + r1) / 2;
                int m2 = (l2 + r2) / 2;

                if (nums1[m1] >= nums2[m2]) {
                    return nums1[m1];
                }

            }

            return 0;

        }
    }
}
