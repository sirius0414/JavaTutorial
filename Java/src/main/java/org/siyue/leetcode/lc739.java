package org.siyue.leetcode;

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
            // TODO: 实现方法
            return new int[0];
        }
    }
}
