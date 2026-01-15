package org.siyue.leetcode.graph;

public class lc994 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int result = solution.orangesRotting(grid);
        System.out.println(result);
        
        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int result2 = solution.orangesRotting(grid2);
        System.out.println(result2);
        
        int[][] grid3 = {{0, 2}};
        int result3 = solution.orangesRotting(grid3);
        System.out.println(result3);
    }

    static class Solution {
        public int orangesRotting(int[][] grid) {
            // TODO: 实现方法
            return 0;
        }
    }
}
