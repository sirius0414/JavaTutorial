package org.siyue.leetcode.arrayHash;

import java.util.*;

public class lc56 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        System.out.println(Arrays.deepToString(solution.merge(intervals)));
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            List<int[]> list = new ArrayList<>();
            int i = 0;
            int left = intervals[i][0];
            int right = intervals[i][1];

            for (i = 1; i < intervals.length; i++) {
                if (intervals[i][0] > right) {
                    // no lapping:
                    list.add(new int[]{left, right});
                    left = intervals[i][0];
                    right = intervals[i][1];
                } else {
                    // overlapping
                    if (intervals[i][1] > right) {
                        right = intervals[i][1];
                    }
                }
            }

            list.add(new int[]{left, right});
            int[][] result = new int[list.size()][2];

            return list.toArray(result);
        }
    }


}
