package org.siyue.leetcode.others;

import java.util.ArrayList;
import java.util.List;

public class lc3751 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int num1 = 120;
        int num2 = 130;
        int result = solution.totalWaviness(num1, num2);
        System.out.println(result);
    }

    static class Solution {
        public int totalWaviness(int num1, int num2) {
            // 直接遍历
            int result = 0;
            for (int i = num1; i <= num2; i++) {
                result += getWaviness(i);
            }

            return result;
        }

        public int getWaviness(int num) {
            String numStr = String.valueOf(num);
            int waviness = 0;

            for (int i = 1; i < numStr.length() - 1; i++) {
                char prev = numStr.charAt(i - 1);
                char curr = numStr.charAt(i);
                char next = numStr.charAt(i + 1);

                if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                    waviness++;
                }
            }

            return waviness;
        }
    }
}
