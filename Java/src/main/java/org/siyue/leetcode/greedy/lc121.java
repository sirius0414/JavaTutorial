package org.siyue.leetcode;

public class lc121 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = solution.maxProfit(prices);
        System.out.println(result);
        
        int[] prices2 = {7, 6, 4, 3, 1};
        int result2 = solution.maxProfit(prices2);
        System.out.println(result2);
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            // TODO: 实现方法
            return 0;
        }
    }
}
