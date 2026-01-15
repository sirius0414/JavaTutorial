package org.siyue.leetcode.matrix;

import java.util.Arrays;

public class lc73 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
        
        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }

    static class Solution {
        public void setZeroes(int[][] matrix) {
            // TODO: 实现方法
        }
    }
}
