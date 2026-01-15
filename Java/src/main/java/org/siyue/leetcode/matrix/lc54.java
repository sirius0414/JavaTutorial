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
            // TODO: 实现方法
            return new ArrayList<>();
        }
    }
}
