package org.siyue.leetcode.bitsMath;

import java.util.Arrays;

public class lc31 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        
        int[] nums2 = {3, 2, 1};
        solution.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));
        
        int[] nums3 = {1, 1, 5};
        solution.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3));
    }

    static class Solution {
        public void nextPermutation(int[] nums) {
            // TODO: 实现方法
        }
    }
}
