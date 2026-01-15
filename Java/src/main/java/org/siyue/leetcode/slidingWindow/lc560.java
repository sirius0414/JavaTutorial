package org.siyue.leetcode;

import java.util.*;
import java.util.concurrent.Phaser;

public class lc560 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,4,3,2,1};
        int k = 6;
        System.out.println(solution.subarraySum(nums, k));
    }

    static class Solution {
        public int subarraySum(int[] nums, int k) {
            int[] preflixSums = new int[nums.length + 1];

            int temp_sum = 0;
            preflixSums[0] = temp_sum;
            for (int i = 0; i < nums.length; i++) {
                temp_sum += nums[i];
                preflixSums[i + 1] = temp_sum;
            }

            int result = 0;
            for (int i = 0; i < preflixSums.length; i++) {
                for (int j = i + 1; j < preflixSums.length; j++) {
                    if (preflixSums[i] + k == preflixSums[j]) {
                        result ++;
                    }
                }
            }

            return result;
        }
    }
}
