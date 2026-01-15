package org.siyue.leetcode.stack;

public class lc394 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String s = "3[a]2[bc]";
        String result = solution.decodeString(s);
        System.out.println(result);
        
        String s2 = "3[a2[c]]";
        String result2 = solution.decodeString(s2);
        System.out.println(result2);
        
        String s3 = "2[abc]3[cd]ef";
        String result3 = solution.decodeString(s3);
        System.out.println(result3);
    }

    static class Solution {
        public String decodeString(String s) {
            // TODO: 实现方法
            return "";
        }
    }
}
