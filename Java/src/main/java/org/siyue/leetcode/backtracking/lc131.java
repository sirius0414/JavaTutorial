package org.siyue.leetcode;

import java.util.*;

public class lc131 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String s = "aab";
        List<List<String>> result = solution.partition(s);
        System.out.println(result);
        
        String s2 = "a";
        List<List<String>> result2 = solution.partition(s2);
        System.out.println(result2);
    }

    static class Solution {
        public List<List<String>> partition(String s) {
            // TODO: 实现方法
            return new ArrayList<>();
        }
    }
}
