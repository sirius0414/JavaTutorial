package org.siyue.leetcode.arrayHash;

public class lc11 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solution.maxArea(height);
        System.out.println(result);
        
        int[] height2 = {1, 1};
        int result2 = solution.maxArea(height2);
        System.out.println(result2);
    }

    static class Solution {
        public int maxArea(int[] height) {
            // TODO: 实现方法
            return 0;
        }
    }
}
