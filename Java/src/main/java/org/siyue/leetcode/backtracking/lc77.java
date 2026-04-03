package org.siyue.leetcode.backtracking;

import java.util.*;

public class lc77 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int n = 4;
        int k = 2;
        List<List<Integer>> result = solution.combine(n, k);
        System.out.println(result);

        int n2 = 1;
        int k2 = 1;
        List<List<Integer>> result2 = solution.combine(n2, k2);
        System.out.println(result2);
    }

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            // TODO: 实现方法
            return new ArrayList<>();
        }
    }
}
