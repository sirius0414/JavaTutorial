package org.siyue.leetcode;

import java.util.*;

public class lc22 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int n = 3;
        List<String> result = solution.generateParenthesis(n);
        System.out.println(result);
        
        int n2 = 1;
        List<String> result2 = solution.generateParenthesis(n2);
        System.out.println(result2);
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            // TODO: 实现方法
            return new ArrayList<>();
        }
    }
}
