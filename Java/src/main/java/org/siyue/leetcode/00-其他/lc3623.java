package org.siyue.leetcode;

import java.util.*;
import java.util.stream.Collectors;

import org.siyue.utils.Combination;

public class lc3623 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();

        int[][] points = {{0,0},{1,0},{2,1},{3,1},{4,0}};
        int res = solution.countTrapezoids(points);
        System.out.println(res); // Expected output: 3
    }

    static class Solution {
        public int countTrapezoids(int[][] points) {
            final int MOD = 1_000_000_007;
            // Generate a HashMap to store the count of points for each unique y-coordinate
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] point : points) {
                map.put(point[1], map.getOrDefault(point[1], 0) + 1);
            }

//            垃圾慢方法：O (n^2) 没必要在两层for loop里算combination，重复算了很多次Combination，因为k一直等于2
//            List<Integer> sortedKeySet = map.keySet().stream().sorted().toList();
//            for (int p : sortedKeySet) {
//                for (int q : sortedKeySet) {
//                    if (p >= q) {
//                        continue;
//                    }
//                    int pointsCount1 = map.get(p);
//                    int pointsCount2 = map.get(q);
//                    if (pointsCount1 > 1 && pointsCount2 > 1) {
//                        long comb1 = Combination.combination(pointsCount1, 2);
//                        long comb2 = Combination.combination(pointsCount2, 2);
//                        res = (res + (comb1 * comb2)) % MOD;
//                    }
//                }
//            }

            // Faster version
            long combSum = 0;
            long combSumSquare = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                long comb = Combination.combination(entry.getValue(), 2) % MOD;
                // Even Faster, use formula \sum_{i<j} a_i a_j=\frac{\left(\sum_i a_i\right)^2-\sum_i a_i^2}{2}
                combSum =  (comb + combSum) % MOD;
                combSumSquare = (combSumSquare + (comb * comb) % MOD) % MOD;
            }
            if (combSum == 0) {
                // No horizontal segment at all
                return 0;
            }

            // sum_{i<j} a_i * a_j = ( (sum a_i)^2 - sum a_i^2 ) / 2
            long res = (combSum * combSum) % MOD;
            res = (res - combSumSquare) % MOD;
            if (res < 0) {
                res += MOD;
            }

            long inv2 = (MOD + 1) / 2; // modular inverse of 2 under MOD
            res = (res * inv2) % MOD;

            return (int) res;
        }
    }
}
