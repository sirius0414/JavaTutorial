package org.siyue.leetcode.matrix;

import java.util.*;

public class lc54 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result);
        
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> result2 = solution.spiralOrder(matrix2);
        System.out.println(result2);
    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

            // 4 bonds, upper and bot, left and right
            int top = 0, bottom = matrix.length - 1;
            int left = 0, right = matrix[0].length - 1;

            while (top <= bottom && left <= right) {
                // left -> right
                for (int j = left; j <= right; j++) {
                    res.add(matrix[top][j]);
                }
                top++;

                // top -> bottom
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;

                if (top <= bottom) {
                    // right -> left
                    for (int j = right; j >= left; j--) res.add(matrix[bottom][j]);
                    bottom--;
                }

                if (left <= right) {
                    // bottom -> top
                    for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
                    left++;
                }
            }
            return res;
        }

    }
}
