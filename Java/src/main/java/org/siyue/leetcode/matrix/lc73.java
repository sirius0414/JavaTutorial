package org.siyue.leetcode.matrix;

import java.util.Arrays;
import java.util.HashSet;

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
            HashSet<Integer> rows = new HashSet<>();
            HashSet<Integer> cols = new HashSet<>();

            int m = matrix.length;
            int n = matrix[0].length;

            // 1) 记录哪些行/列需要清零
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        rows.add(i);
                        cols.add(j);
                    }
                }
            }

            // 2) 遍历整个矩阵，命中行/列就置 0
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rows.contains(i) || cols.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
