package org.siyue.leetcode.stack;

import java.util.Arrays;

public class lc739 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));
        
        int[] temperatures2 = {30, 40, 50, 60};
        int[] result2 = solution.dailyTemperatures(temperatures2);
        System.out.println(Arrays.toString(result2));
        
        int[] temperatures3 = {30, 60, 90};
        int[] result3 = solution.dailyTemperatures(temperatures3);
        System.out.println(Arrays.toString(result3));
    }

    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            // 单调递减栈，存储温度的索引
            int[] result = new int[temperatures.length];
            int[] stack = new int[temperatures.length];
            int top = -1; // 栈顶指针

            for (int i = 0; i < temperatures.length; i++) {
                while (top >= 0 && temperatures[i] > temperatures[stack[top]]) {
                    int prevIndex = stack[top--]; // 弹出栈顶索引
                    result[prevIndex] = i - prevIndex; // 计算等待天数
                }
                stack[++top] = i; // 将当前索引入栈
            }

            return result;
        }
    }
}
