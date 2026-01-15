package org.siyue.leetcode.others;

import java.util.*;

public class lc16 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int result = solution.threeSumClosest(nums, target);
        System.out.println(result);
    }

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int n = nums.length;
            Arrays.sort(nums);

            int close_sum = nums[0] + nums[1] + nums[2];
            int min_diff = Math.abs(target - close_sum);

            for (int i=0; i<n-2; i++) {
                int left_pointer = i + 1;
                int right_pointer = n - 1;

                while (left_pointer < right_pointer) {
                    int sum = nums[i] + nums[left_pointer] + nums[right_pointer];
                    int diff = Math.abs(sum - target);
                    if (diff < min_diff) {
                        close_sum = sum;
                        min_diff = diff;
                    }

                    if (target < sum) {
                        // 大了
                        right_pointer--;
                    }

                    if (target > sum) {
                        // 小了
                        left_pointer++;
                    }

                    if (target == sum) {
                        // 敢这么写是因为LC16要求只存在恰好一个解!
                        // 不然的换循环会到这一步卡在这里，因为左右指针不会移动了！
                        return sum;
                    }
                }
            }
            return close_sum;
        }
    }
}
