package org.siyue.leetcode.others;

import java.util.Arrays;

public class lc2126 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int mass = 10;
        int[] asteroids = {3, 9, 19, 5, 21};
        boolean result = solution.asteroidsDestroyed(mass, asteroids);
        System.out.println(result);
    }

    static class Solution {
        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
            Arrays.sort(asteroids);
            long sum = mass;
            for (int asteroid : asteroids) {
                if (sum < asteroid) {
                    return false;
                }
                sum += asteroid;
            }

            return true;

        }
    }
}
