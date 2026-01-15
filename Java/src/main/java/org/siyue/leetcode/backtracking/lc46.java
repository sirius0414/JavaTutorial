package org.siyue.leetcode.backtracking;

import java.util.*;

public class lc46 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        System.out.println(result);
        
        int[] nums2 = {0, 1};
        List<List<Integer>> result2 = solution.permute(nums2);
        System.out.println(result2);
        
        int[] nums3 = {1};
        List<List<Integer>> result3 = solution.permute(nums3);
        System.out.println(result3);
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            // TODO: 实现方法
            return new ArrayList<>();
        }
    }
}
