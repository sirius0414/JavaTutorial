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
            // TODO: 实现方法
            return new int[0];
        }
    }
}
