package org.siyue.leetcode.backtracking;

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
            Integer left_parenthese = n; // 左括号剩余数量
            Integer right_parenthese = n; // 右括号剩余数量
            List<String> result = new ArrayList<>();
            StringBuilder path = new StringBuilder();

            dfs(left_parenthese, right_parenthese, path, result);
            return  result;
        }

        public void dfs(Integer l,  Integer r, StringBuilder path, List<String> result) {
            // 终止条件，左右括号的剩余数量都是0
            if (l == 0 && r == 0) {
                // add path to result
                result.add(path.toString());
                return;
            }

            // 选择左括号，前提是左括号剩余数量大于0
            if (l > 0) {
                path.append('(');
                dfs(l - 1, r, path, result);
                // 回退，撤销选择
                path.deleteCharAt(path.length() - 1);
            }

            // 选择右括号，前提是右括号剩余数量大于0，并且右括号剩余数量必须大于左括号剩余数量
            if (r > 0 && r > l) {
                path.append(')');
                dfs(l, r - 1, path, result);
                // 回退，撤销选择
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
