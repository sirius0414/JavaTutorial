package org.siyue.leetcode.arrayHash;

import java.util.Arrays;

public class lc189 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
        
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        solution.rotate(nums2, k2);
        System.out.println(Arrays.toString(nums2));
    }

    static class Solution {
        public void rotate(int[] nums, int k) {

            k = k % nums.length;

            int [] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i + k < nums.length) {
                    result[i + k] = nums[i];
                } else {
                    result[i + k - nums.length] = nums[i];
                }
            }
            System.arraycopy(result, 0, nums, 0, result.length);
        }
    }
}
