package org.siyue.leetcode;

public class lc79 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean result = solution.exist(board, word);
        System.out.println(result);
        
        char[][] board2 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word2 = "SEE";
        boolean result2 = solution.exist(board2, word2);
        System.out.println(result2);
        
        char[][] board3 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word3 = "ABCB";
        boolean result3 = solution.exist(board3, word3);
        System.out.println(result3);
    }

    static class Solution {
        public boolean exist(char[][] board, String word) {
            // TODO: 实现方法
            return false;
        }
    }
}
