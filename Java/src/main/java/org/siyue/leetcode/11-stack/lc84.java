package org.siyue.leetcode;

public class lc84 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = solution.largestRectangleArea(heights);
        System.out.println(result);
        
        int[] heights2 = {2, 4};
        int result2 = solution.largestRectangleArea(heights2);
        System.out.println(result2);
    }

    static class Solution {
        public int largestRectangleArea(int[] heights) {
            // TODO: 实现方法
            return 0;
        }
    }
}
