package org.siyue.leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc3577 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] complexity = {1,2,3,4,5};
        int result = solution.countPermutations(complexity);
        System.out.println(result);
    }

    static class Solution {
        public int countPermutations(int[] complexity) {
            int n = complexity.length;
            long MOD = 1_000_000_007;

            long factorize = 1;
            // Factorize from n-1 to 1
            for (int i = 1; i < n; i++) {
                if (complexity[i] < complexity[0]) {
                    return 0;
                }
                factorize = (factorize * i) % MOD;
            }
            return (int) factorize;
        }
    }
}