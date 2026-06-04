package org.siyue.leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc3161 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] queries = {
                {1, 2},
                {2, 3, 3},
                {2, 3, 1},
                {2, 2, 2}
        };
        List<Boolean> result = solution.getResults(queries);
        System.out.println(result);
    }

    static class Solution {
        public List<Boolean> getResults(int[][] queries) {
            List<Boolean> resultList = new ArrayList<>();

            List<Integer> obstacles = new ArrayList<>();
            for (int[] query : queries) {
                int type = query[0];

                if (type == 1) {
                    // 添加障碍物
                    obstacles.add(query[1]);
                } else if (type == 2) {
                    // 查询是否能通过
                    int x = query[1];
                    int size = query[2];

                    int start = 0;
                    int maxInterval = 0;

                    for (int obstacle : obstacles) {
                        if (obstacle > x) {
                            break;
                        }

                        int lenInterval = obstacle - start;
                        maxInterval = Math.max(maxInterval, lenInterval);
                        start = obstacle;
                    }

                    // 最后一段：最后一个障碍物到 x
                    maxInterval = Math.max(maxInterval, x - start);

                    resultList.add(maxInterval >= size);
                }
            }

            return resultList;
        }
    }
}
