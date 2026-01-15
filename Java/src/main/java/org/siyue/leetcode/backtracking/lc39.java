package org.siyue.leetcode.backtracking;

import java.util.*;

public class lc39 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println(result);
        
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        List<List<Integer>> result2 = solution.combinationSum(candidates2, target2);
        System.out.println(result2);
    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            // TODO: 实现方法
            return new ArrayList<>();
        }
    }
}
