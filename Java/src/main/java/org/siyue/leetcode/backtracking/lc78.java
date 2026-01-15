package org.siyue.leetcode.backtracking;

import java.util.*;

public class lc78 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
        
        int[] nums2 = {0};
        List<List<Integer>> result2 = solution.subsets(nums2);
        System.out.println(result2);
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            // TODO: 实现方法
            return new ArrayList<>();
        }
    }
}
