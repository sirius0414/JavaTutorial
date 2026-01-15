package org.siyue.leetcode.dp;

import java.util.*;

public class lc139 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean result = solution.wordBreak(s, wordDict);
        System.out.println(result);
        
        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        boolean result2 = solution.wordBreak(s2, wordDict2);
        System.out.println(result2);
        
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean result3 = solution.wordBreak(s3, wordDict3);
        System.out.println(result3);
    }

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            // TODO: 实现方法
            return false;
        }
    }
}
