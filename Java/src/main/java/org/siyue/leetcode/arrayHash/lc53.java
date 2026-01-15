package org.siyue.leetcode.arrayHash;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class lc53 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums ={-1};

        System.out.println(solution.maxSubArray(nums));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int[] sumNums = new int[nums.length + 1];

            sumNums[0] = 0;
            int acc = 0;
            int maxGap = Integer.MIN_VALUE;
            int minS = 0;
            for (int i = 1; i <= nums.length; i++) {
                acc += nums[i -1];
                sumNums[i] = acc;

                if (maxGap < sumNums[i] - minS) {
                    maxGap = sumNums[i] - minS;
                }

                //对于位置i的积分sumNum[i],要找到这前面最小的值，并记录
                if (minS > sumNums[i]) {
                    minS = sumNums[i];
                }

            }
            return maxGap;
        }
    }

}
