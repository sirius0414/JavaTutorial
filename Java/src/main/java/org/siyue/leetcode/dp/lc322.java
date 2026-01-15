package org.siyue.leetcode.dp;

public class lc322 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = solution.coinChange(coins, amount);
        System.out.println(result);
        
        int[] coins2 = {2};
        int amount2 = 3;
        int result2 = solution.coinChange(coins2, amount2);
        System.out.println(result2);
        
        int[] coins3 = {1};
        int amount3 = 0;
        int result3 = solution.coinChange(coins3, amount3);
        System.out.println(result3);
    }

    static class Solution {
        public int coinChange(int[] coins, int amount) {
            // TODO: 实现方法
            return 0;
        }
    }
}
