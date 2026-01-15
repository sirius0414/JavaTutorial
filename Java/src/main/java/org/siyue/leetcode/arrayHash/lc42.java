package org.siyue.leetcode.arrayHash;

public class lc42 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {4,2,0,3,2,5};
        Integer result = solution.trap(nums);
        System.out.println(result);
    }

    static class Solution {
        public int trap(int[] height) {
            // Two Preflix List of Int
            int n = height.length;

            int[] maxHeightLeft = new int[n];
            int[] maxHeightRight = new int[n];

            int maxLeft = 0;
            int maxRight = 0;

            int result = 0;

            for (int i = 0; i < n - 1; i++) {
                // left
                maxLeft = Math.max(maxLeft, height[i]);
                maxHeightLeft[i] = maxLeft;

                // right
                maxRight = Math.max(maxRight, height[n-1-i]);
                maxHeightRight[i] = maxRight;
            }

            // Catching the Rain
            for (int i = 1; i < n - 1; i++) {
                int leftWall = maxHeightLeft[i];
                int rightWall = maxHeightRight[n-1-i];

                int wall = Math.min(leftWall, rightWall);
                if (wall > height[i]) {
                    result += (wall - height[i]);
                }
            }

            return result;
        }
    }
}
