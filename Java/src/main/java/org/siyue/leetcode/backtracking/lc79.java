package org.siyue.leetcode.backtracking;

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
            // 全零矩阵来记录哪个位置被用过了
            boolean[][] visited = new boolean[board.length][board[0].length];

            // 遍历每个位置，作为起点进行DFS
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, word, 0, i, j, visited)) {
                        return true; // 找到了一条路径，返回true
                    }
                }
            }

            // 没找到咯
            return false;
        }

        // DFS
        boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
            if (index == word.length()) {
                return true;
            }

            if (x < 0 || x >= board.length ||
                    y < 0 || y >= board[0].length ||
                    visited[x][y] ||
                    board[x][y] != word.charAt(index)) {
                return false;
            }

            visited[x][y] = true;

            boolean found =
                    dfs(board, word, index + 1, x - 1, y, visited) ||
                            dfs(board, word, index + 1, x + 1, y, visited) ||
                            dfs(board, word, index + 1, x, y - 1, visited) ||
                            dfs(board, word, index + 1, x, y + 1, visited);

            visited[x][y] = false;

            return found;
        }
    }
}
