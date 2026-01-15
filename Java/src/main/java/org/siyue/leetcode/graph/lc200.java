package org.siyue.leetcode.graph;

public class lc200 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        int result = solution.numIslands(grid);
        System.out.println(result);
        
        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        int result2 = solution.numIslands(grid2);
        System.out.println(result2);
    }

    static class Solution {
        public int numIslands(char[][] grid) {
            // TODO: 实现方法
            return 0;
        }
    }
}
