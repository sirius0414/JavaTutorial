package org.siyue.leetcode;

public class lc32 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String s = "(()";
        int result = solution.longestValidParentheses(s);
        System.out.println(result);
        
        String s2 = ")()())";
        int result2 = solution.longestValidParentheses(s2);
        System.out.println(result2);
        
        String s3 = "";
        int result3 = solution.longestValidParentheses(s3);
        System.out.println(result3);
    }

    static class Solution {
        public int longestValidParentheses(String s) {
            // TODO: 实现方法
            return 0;
        }
    }
}
