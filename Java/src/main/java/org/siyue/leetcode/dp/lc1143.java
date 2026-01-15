package org.siyue.leetcode;

public class lc1143 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String text1 = "abcde";
        String text2 = "ace";
        int result = solution.longestCommonSubsequence(text1, text2);
        System.out.println(result);
        
        String text12 = "abc";
        String text22 = "abc";
        int result2 = solution.longestCommonSubsequence(text12, text22);
        System.out.println(result2);
        
        String text13 = "abc";
        String text23 = "def";
        int result3 = solution.longestCommonSubsequence(text13, text23);
        System.out.println(result3);
    }

    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            // TODO: 实现方法
            return 0;
        }
    }
}
