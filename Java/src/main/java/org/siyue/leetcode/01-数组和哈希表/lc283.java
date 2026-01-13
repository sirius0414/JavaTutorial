package org.siyue.leetcode;

public class lc283 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = new int[]{0,1,0,3,12};
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }

            int pos = 0; // next position to place non-zero

            // First pass: move non-zero elements forward
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[pos] = nums[i];
                    // Optional: set original position to zero if indices differ
                    if (i != pos) {
                        nums[i] = 0;
                    }
                    pos++;
                }
            }
        }
    }
}
