package org.siyue.leetcode;

import java.util.*;

public class lc15 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {0,0,0,0};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();

            if (n == 3) {
                int sum = nums[0] + nums[1] + nums[2];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[0], nums[1], nums[2]));
                    return result;
                } else {
                    return result;
                }
            }

            for (int i = 0; i < n - 2; i++) {

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue; // dedup i
                }

                int leftPointer = i + 1;
                int rightPointer = n - 1;

                while (leftPointer < rightPointer) {
                    int sum = nums[i] + nums[leftPointer] + nums[rightPointer];

                    if (sum < 0) {
                        leftPointer++;
                    } else if (sum > 0) {
                        rightPointer--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[leftPointer], nums[rightPointer]));
                        int leftval = nums[leftPointer];
                        int rightval = nums[rightPointer];

                        while (leftPointer < rightPointer && nums[leftPointer] == leftval) {
                            leftPointer++;
                        }

                        while (leftPointer < rightPointer && nums[rightPointer] == rightval) {
                            rightPointer--;
                        }
                    }
                }
            }

            return result;

        }
    }
}
