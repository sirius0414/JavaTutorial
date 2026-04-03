package org.siyue.leetcode.backtracking;

import java.util.*;

public class lc90 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        System.out.println(result);

        int[] nums2 = {0};
        List<List<Integer>> result2 = solution.subsetsWithDup(nums2);
        System.out.println(result2);
    }

    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            // TODO: 实现方法
            return new ArrayList<>();
        }
    }
}
