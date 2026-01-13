package org.siyue.leetcode;

import java.util.*;

public class lc1 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
        
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println(Arrays.toString(result2));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            // TODO: 实现方法
            return new int[0];
        }
    }
}
