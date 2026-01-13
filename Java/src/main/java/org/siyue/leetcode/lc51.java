package org.siyue.leetcode;

import java.util.*;

public class lc51 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int n = 4;
        List<List<String>> result = solution.solveNQueens(n);
        System.out.println(result);
        
        int n2 = 1;
        List<List<String>> result2 = solution.solveNQueens(n2);
        System.out.println(result2);
    }

    static class Solution {
        public List<List<String>> solveNQueens(int n) {
            // TODO: 实现方法
            return new ArrayList<>();
        }
    }
}
