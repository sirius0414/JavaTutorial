package org.siyue.leetcode.stack;

public class lc84 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = solution.largestRectangleArea(heights);
        System.out.println(result);
        
        int[] heights2 = {2, 4, 6, 8, 10};
        int result2 = solution.largestRectangleArea(heights2);
        System.out.println(result2);
    }

    static class Solution {
        public int largestRectangleArea(int[] heights) {
            // 两个单调递增栈，遍历一次heights数组，对于i，分别找左侧和右侧第一个小于于heights[i]的index
            int[] stack_right = new int[heights.length];
            int[] stack_left = new int[heights.length];

            // 两个结果矩阵，存左，右侧第一个小值距离
            int[] result_left = new int[heights.length];
            int[] result_right = new int[heights.length];

            // 栈顶指针
            int top_r = -1;
            int top_l = -1;

            for (int i = 0; i < heights.length; i++) {
                // 从左向右遍历
                while (top_r >= 0 && heights[i] < heights[stack_right[top_r]]) {
                    // 如果当前来的高度h[i] 小于栈顶的高度，说明top终于等到了比它小的（右侧）, 需要pop出栈顶，记录结果
                    int prevIndex = stack_right[top_r--];
                    result_right[prevIndex] = i - prevIndex; // 记录右侧第一个小值的距离
                }
                // 当前索引入栈
                stack_right[++top_r] = i;

                // 从右向左遍历
                int j = heights.length - 1 - i;
                while (top_l >= 0 && heights[j] < heights[stack_left[top_l]]) {
                    // 如果当前来的高度h[i] 小于栈顶的高度，说明top终于等到了比它小的（右侧）, 需要pop出栈顶，记录结果
                    int prevIndex = stack_left[top_l--];
                    result_left[prevIndex] = prevIndex - j; // 记录右侧第一个小值的距离
                }
                // 当前索引入栈
                stack_left[++top_l] = j;
            }

            // 右侧一直没有更小的
            while (top_r >= 0) {
                int index = stack_right[top_r--];
                result_right[index] = heights.length - index;
            }

            // 左侧一直没有更小的
            while (top_l >= 0) {
                int index = stack_left[top_l--];
                result_left[index] = index + 1;
            }

            // 计算结果
            int result = 0;
            for (int i = 0; i < heights.length; i++) {
                int area = heights[i] * (result_left[i] + result_right[i] - 1); // 减去1是因为当前柱子被重复计算了
                result = Math.max(result, area);
            }

            return result;
        }
    }
}
