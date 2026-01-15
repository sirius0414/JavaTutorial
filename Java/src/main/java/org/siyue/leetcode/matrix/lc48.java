package org.siyue.leetcode.matrix;

import java.util.Arrays;

public class lc48 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        
        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        solution.rotate(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            // TODO: 实现方法
        }
    }
}
