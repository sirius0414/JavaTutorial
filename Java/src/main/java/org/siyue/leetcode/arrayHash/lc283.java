package org.siyue.leetcode.arrayHash;

import java.util.Arrays;

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

        }
    }
}
