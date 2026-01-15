package org.siyue.leetcode.others;

import java.util.HashMap;
import java.util.Map;

public class lc3583 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,2,4,2};
        int result = solution.specialTriplets(nums);
        System.out.println(result);
    }

    static class Solution {
        public int specialTriplets(int[] nums) {
            final long MOD = 1_000_000_007L;
            int n = nums.length;

            // rightCount 先统计所有元素的频次
            Map<Integer, Long> rightCount = new HashMap<>();
            for (int x : nums) {
                rightCount.put(x, rightCount.getOrDefault(x, 0L) + 1L);
            }

            Map<Integer, Long> leftCount = new HashMap<>();
            long result = 0L;

            for (int j = 0; j < n; j++) {
                int mid = nums[j];

                // 当前 j 位置不再属于右侧，先从 rightCount 中移除一个
                long rc = rightCount.get(mid) - 1L;
                if (rc == 0L) {
                    rightCount.remove(mid);
                } else {
                    rightCount.put(mid, rc);
                }

                // 我们需要 nums[p1] = nums[p3] = 2 * mid
                int need = 2 * mid; // 若担心溢出，可改用 long 作为 key

                long leftCnt = leftCount.getOrDefault(need, 0L);
                long rightCnt = rightCount.getOrDefault(need, 0L);

                if (leftCnt > 0 && rightCnt > 0) {
                    long add = (leftCnt % MOD) * (rightCnt % MOD) % MOD;
                    result += add;
                    if (result >= MOD) {
                        result -= MOD;
                    }
                }

                // 把当前 mid 放到左侧计数中，供后续位置使用
                leftCount.put(mid, leftCount.getOrDefault(mid, 0L) + 1L);
            }

            return (int) (result % MOD);
        }
    }
}