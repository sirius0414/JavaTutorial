package org.siyue.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc239 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(solution.maxSlidingWindow(arr, k));
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k <= 0) return new int[0];
            int n = nums.length;
            int[] res = new int[n - k + 1];

            // Store indices, nums[idx] is decreasing in deque from front to back
            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                // 1) Remove indices out of window [i-k+1, i]
                int left = i - k + 1;
                // left就是窗口左侧下标
                while (!dq.isEmpty() && dq.peekFirst() < left) {
                    // 如果dq最左侧的元素（也就是最大值的下标）小于窗口，说明窗口已经离开，需要弹出这个元素
                    dq.pollFirst();
                }

                // 2) Maintain decreasing order: pop smaller/equal from back
                while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                    dq.pollLast();
                }
                dq.addLast(i);

                // 3) Window formed, record max (front)
                if (i >= k - 1) {
                    res[left] = nums[dq.peekFirst()];
                }
            }
            return res;
        }
    }
}
