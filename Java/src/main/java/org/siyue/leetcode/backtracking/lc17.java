package org.siyue.leetcode.backtracking;

import java.util.*;

public class lc17 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String digits = "23";
        List<String> result = solution.letterCombinations(digits);
        System.out.println(result);
        
        String digits2 = "";
        List<String> result2 = solution.letterCombinations(digits2);
        System.out.println(result2);
        
        String digits3 = "2";
        List<String> result3 = solution.letterCombinations(digits3);
        System.out.println(result3);
    }

    static class Solution {
        public List<String> letterCombinations(String digits) {
            // TODO: 实现方法
            return new ArrayList<>();
        }
    }
}
