package org.siyue.leetcode.others;

public class lc3633 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] landStartTime = {2, 8};
        int[] landDuration = {4, 1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};
        int result = solution.earliestFinishTime(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration
        );
        System.out.println(result);
    }

    static class Solution {
        public int earliestFinishTime(
                int[] landStartTime,
                int[] landDuration,
                int[] waterStartTime,
                int[] waterDuration
        ) {
            int ans = Integer.MAX_VALUE;

            // 先 land，后 water
            for (int i = 0; i < landStartTime.length; i++) {
                int landEnd = landStartTime[i] + landDuration[i];

                for (int j = 0; j < waterStartTime.length; j++) {
                    int waterBegin = Math.max(landEnd, waterStartTime[j]);
                    int totalEnd = waterBegin + waterDuration[j];

                    ans = Math.min(ans, totalEnd);
                }
            }

            // 先 water，后 land
            for (int i = 0; i < waterStartTime.length; i++) {
                int waterEnd = waterStartTime[i] + waterDuration[i];

                for (int j = 0; j < landStartTime.length; j++) {
                    int landBegin = Math.max(waterEnd, landStartTime[j]);
                    int totalEnd = landBegin + landDuration[j];

                    ans = Math.min(ans, totalEnd);
                }
            }

            return ans;
        }
    }
}
