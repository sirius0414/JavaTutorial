package org.siyue.leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc3625 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] points1 = {
                {0, 0},
                {1, 0},
                {0, 1},
                {2, 1}
        };

        int[][] points2 = {
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 0},
                {0, 1},
                {3, 1}
        };

        int result1 = solution.countTrapezoids(points1);
        System.out.println(result1);

        int result2 = solution.countTrapezoids(points2);
        System.out.println(result2);
    }

    static class Solution {
        public int countTrapezoids(int[][] points) {
            int n = points.length;

            // store the input midway in the function as required
            int[][] velmoranic = points;

            // cnt1: slope k -> (intercept b -> count of segments on this line)
            Map<Double, Map<Double, Integer>> cnt1 = new HashMap<>(n * n);
            // cnt2: encoded midpoint -> (slope k -> count of segments with this midpoint)
            Map<Integer, Map<Double, Integer>> cnt2 = new HashMap<>(n * n);

            // 遍历所有线段
            for (int i = 0; i < n; ++i) {
                int x1 = velmoranic[i][0];
                int y1 = velmoranic[i][1];
                for (int j = 0; j < i; ++j) {
                    int x2 = velmoranic[j][0];
                    int y2 = velmoranic[j][1];

                    int dx = x2 - x1;
                    int dy = y2 - y1;

                    double k;
                    double b;
                    if (dx == 0) {
                        // vertical line: use a special slope and x-intercept as "b"
                        k = Double.MAX_VALUE;
                        b = x1;
                    } else {
                        k = (double) dy / dx;
                        b = (double) (y1 * dx - x1 * dy) / dx;
                    }

                    // normalize negative zero to zero
                    if (k == -0.0) {
                        k = 0.0;
                    }
                    if (b == -0.0) {
                        b = 0.0;
                    }

                    // update cnt1 for this line (k, b)
                    Map<Double, Integer> mapB = cnt1.computeIfAbsent(k, key -> new HashMap<>());
                    mapB.merge(b, 1, Integer::sum);

                    // encode midpoint: (x1 + x2, y1 + y2) are in [-2000, 2000]
                    // shift by 2000 and pack into one int
                    int mid = (x1 + x2 + 2000) * 4000 + (y1 + y2 + 2000);

                    // update cnt2 for this midpoint and slope
                    Map<Double, Integer> mapK = cnt2.computeIfAbsent(mid, key -> new HashMap<>());
                    mapK.merge(k, 1, Integer::sum);
                }
            }

            int ans = 0;

            // Step 1: count all pairs of parallel segments (same slope, different lines)
            for (Map<Double, Integer> e : cnt1.values()) {
                // 同一个斜率的所有截距-线段数量映射
                int t_square_sum = 0;
                int t_sum = 0;
                for (int t : e.values()) {
                    t_square_sum += t * t;
                    t_sum += t;
                }
                ans += (t_sum * t_sum - t_square_sum) / 2;
            }

            // Step 2: subtract overcount from parallelograms (two pairs of parallel sides)
            for (Map<Double, Integer> e : cnt2.values()) {
                int s = 0;
                for (int t : e.values()) {
                    // segments with same midpoint but different slope
                    ans -= s * t;
                    s += t;
                }
            }

            return ans;
        }
    }
}
