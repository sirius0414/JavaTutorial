package org.siyue.leetcode.dp;

public class lc72 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String word1 = "horse";
        String word2 = "ros";
        int result = solution.minDistance(word1, word2);
        System.out.println(result);
        
        String word12 = "intention";
        String word22 = "execution";
        int result2 = solution.minDistance(word12, word22);
        System.out.println(result2);
    }

    static class Solution {
        public int minDistance(String word1, String word2) {
            // TODO: 实现方法
            return 0;
        }
    }
}
