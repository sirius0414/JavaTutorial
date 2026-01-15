package org.siyue.leetcode.others;

import java.util.*;

public class lc1925 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int n = 10;
        int result = solution.countTriples(n);
        System.out.println(result);
    }

    static class Solution {
        public int countTriples(int n) {
            List<Integer> squareList = new ArrayList<>();

            int count = 0;

            for (int i = 1; i <= n; i++) {
                squareList.add(i * i);
            }

            for (int a = 0; a < n; a++) {
                for (int b = a + 1; b < n; b++) {
                    int cSquare = squareList.get(a) + squareList.get(b);
                    if (squareList.contains(cSquare)) {
                        count++;
                    }
                }
            }

            return count * 2;

        }
    }

}

