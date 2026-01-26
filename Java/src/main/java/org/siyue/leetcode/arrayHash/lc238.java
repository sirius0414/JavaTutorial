package org.siyue.leetcode.arrayHash;

import java.util.Arrays;

public class lc238 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
        
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.println(Arrays.toString(result2));
    }

    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] preflixSum = new int[nums.length];
            int[] postflixSum = new int[nums.length];

            int p1 = 0, p2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    p1 = nums[i];
                    p2 = nums[nums.length - 1 - i];
                } else {
                    p1 = p1 * nums[i];
                    p2 = p2 * nums[nums.length - 1 - i];
                }
                preflixSum[i] = p1;
                postflixSum[nums.length - 1 - i] = p2;
            }

            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    result[i] = postflixSum[i + 1];
                } else if (i == nums.length - 1) {
                    result[i] = preflixSum[i - 1];
                } else {
                    result[i] = preflixSum[i - 1] * postflixSum[i + 1];
                }
            }

            return result;
        }
    }
}
