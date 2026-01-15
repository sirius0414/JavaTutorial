package org.siyue.leetcode.dp;

public class lc62 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int m = 3, n = 7;
        int result = solution.uniquePaths(m, n);
        System.out.println(result);
        
        int m2 = 3, n2 = 2;
        int result2 = solution.uniquePaths(m2, n2);
        System.out.println(result2);
    }

    static class Solution {
        public int uniquePaths(int m, int n) {
            // TODO: 实现方法
            return 0;
        }
    }
}
