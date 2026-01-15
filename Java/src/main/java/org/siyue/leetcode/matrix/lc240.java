package org.siyue.leetcode.matrix;

public class lc240 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[][] matrix = {{1, 4, 7, 11}, {2, 5, 8, 12}, {3, 6, 9, 16}, {10, 13, 14, 17}};
        int target = 5;
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println(result);
        
        int target2 = 20;
        boolean result2 = solution.searchMatrix(matrix, target2);
        System.out.println(result2);
    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // TODO: 实现方法
            return false;
        }
    }
}
