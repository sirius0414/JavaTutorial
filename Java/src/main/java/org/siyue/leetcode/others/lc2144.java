package org.siyue.leetcode.others;

import java.util.Arrays;

public class lc2144 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] cost = {1, 2, 3};
        int result = solution.minimumCost(cost);
        System.out.println(result);
    }

    static class Solution {
        public int minimumCost(int[] cost) {
            Arrays.sort(cost);
            int totalCost = 0;
            int count = 1;

            for (int i = cost.length - 1; i >= 0; i -= 1) {
                if (count == 3) {
                    // skip
                    count = 1; // reset count after skipping
                } else  {
                    totalCost += cost[i];
                    count++;
                }
            }

            return totalCost;
        }
    }
}
