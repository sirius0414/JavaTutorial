package org.siyue.leetcode;

public class lc3 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String s = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);
        
        String s2 = "bbbbb";
        int result2 = solution.lengthOfLongestSubstring(s2);
        System.out.println(result2);
        
        String s3 = "pwwkew";
        int result3 = solution.lengthOfLongestSubstring(s3);
        System.out.println(result3);
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            // TODO: 实现方法
            return 0;
        }
    }
}
