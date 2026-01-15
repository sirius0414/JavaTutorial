package org.siyue.leetcode;

public class lc64 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int result = solution.minPathSum(grid);
        System.out.println(result);
        
        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}};
        int result2 = solution.minPathSum(grid2);
        System.out.println(result2);
    }

    static class Solution {
        public int minPathSum(int[][] grid) {
            // TODO: 实现方法
            return 0;
        }
    }
}
