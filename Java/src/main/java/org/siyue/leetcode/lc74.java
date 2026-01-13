package org.siyue.leetcode;

public class lc74 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println(result);
        
        int[][] matrix2 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target2 = 13;
        boolean result2 = solution.searchMatrix(matrix2, target2);
        System.out.println(result2);
    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // TODO: 实现方法
            return false;
        }
    }
}
