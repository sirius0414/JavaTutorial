package org.siyue.leetcode.dp;

public class lc799 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();

        int poured = 1;
        int queryRow = 1;
        int queryGlass = 1;
        double result = solution.champagneTower(poured, queryRow, queryGlass);
        System.out.println(result);

        int poured2 = 1    ;
        int queryRow2 = 1;
        int queryGlass2 = 1;
        double result2 = solution.champagneTower(poured2, queryRow2, queryGlass2);
        System.out.println(result2);

        int poured3 = 100000009;
        int queryRow3 = 33;
        int queryGlass3 = 17;
        double result3 = solution.champagneTower(poured3, queryRow3, queryGlass3);
        System.out.println(result3);

        int poured4 = 25;
        int queryRow4 = 6;
        int queryGlass4 = 1;
        double result4 = solution.champagneTower(poured4, queryRow4, queryGlass4);
        System.out.println(result4);
    }

    // 正解 DP：
    static class Solution {
        public double champagneTower(int poured, int query_row, int query_glass) {
            // dp[r][c] = amount in glass at row r, col c (0-indexed)
            double[][] dp = new double[query_row + 2][query_row + 2];
            dp[0][0] = poured;

            for (int r = 0; r <= query_row; r++) {
                for (int c = 0; c <= r; c++) {
                    double overflow = Math.max(0.0, dp[r][c] - 1.0);
                    if (overflow > 0) {
                        double half = overflow / 2.0;
                        dp[r + 1][c] += half;
                        dp[r + 1][c + 1] += half;
                    }
                }
            }
            return Math.min(1.0, dp[query_row][query_glass]);
        }
    }

    // 错误的，上面杯子满了溢出来的量不是线形的：

//    static class Solution {
//        public double champagneTower(int poured, int query_row, int query_glass) {
//            // 题目是从0开始的，我这算法写的从1开始
//            query_row ++;
//            query_glass ++;
//            int P = pouredGlass(query_row, query_glass);
//            if (query_row == query_glass || query_glass == 0) {
//                if (poured >= P) {
//                    // Fulled
//                    return 1.0;
//                } else {
//                    int P0 = pouredGlass(query_row - 1, 1);
//                    return Math.max((poured - P0), 0) * (1.0 / (2.0 * (query_row -  1.0)));
//                }
//            } else {
//                // 先找到目标杯子上面两杯是什么时候满的
//                if (poured >= P) {
//                    return 1.0;
//                }
//                int P1 =  pouredGlass(query_row - 1, query_glass - 1);
//                int P2 =  pouredGlass(query_row - 1, query_glass);
//                return (Math.max(poured - P1, 0) + Math.max(poured - P2, 0)) * (1.0 / (2.0 * (query_row -  1.0)));
//            }
//        }
//
//         public int pouredGlass(int query_row, int query_glass) {
//             // 构建Function F[i][j] = P， 代表在P杯时，i行j列这个杯子满了
//             // 1 <= j <= i + 1; 1 <= i <= 100
//             if (query_row == query_glass ||  query_glass == 0) {
//                 // 找的这是每行的第一/最后一杯
//                 return query_row * (query_glass - 1);
//             } else {
//                 // 找自己上面两个杯子是啥时候满的
//                 int p1 = pouredGlass(query_row - 1, query_glass - 1);
//                 int p2 = pouredGlass(query_row - 1, query_glass);
//                 return  (2 * (query_glass - 1)  + p1 + p2) / 2;
//             }
//         }
//    }
}
