package org.siyue.leetcode.bitsMath;

import java.util.Arrays;

public class lc75 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        
        int[] nums2 = {2, 0, 1};
        solution.sortColors(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    static class Solution {
        public void sortColors(int[] nums) {
            // TODO: 实现方法
        }
    }
}
