package org.siyue.leetcode.stack;

import java.util.Stack;

public class lc20 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String s = "()";
        boolean result = solution.isValid(s);
        System.out.println(result);
        
        String s2 = "()[]{}";
        boolean result2 = solution.isValid(s2);
        System.out.println(result2);
        
        String s3 = "(]";
        boolean result3 = solution.isValid(s3);
        System.out.println(result3);
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '{') {
                    stack.push('}');
                } else if (c == '[') {
                    stack.push(']');
                } else if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
