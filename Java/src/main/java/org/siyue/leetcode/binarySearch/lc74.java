package org.siyue.leetcode.binarySearch;

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
            // 先把每行的收尾加到一个数组中
            for (int i = 0; i < matrix.length; i++) {
                if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]) {
                    // 在这一行里进行二分查找
                    return binarySearch(matrix[i], target) != -1;
                }
            }
            return false;
        }

        // 1-D binary search
        public int binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2; // 防止溢出

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return -1; // 没找到
        }
    }
}
