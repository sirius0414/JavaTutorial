package org.siyue.leetcode.heapPriorityQueue;

public class lc215 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = solution.findKthLargest(nums, k);
        System.out.println(result);
        
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        int result2 = solution.findKthLargest(nums2, k2);
        System.out.println(result2);
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            // TODO: 实现方法
            return 0;
        }
    }
}
