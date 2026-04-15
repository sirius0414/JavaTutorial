package org.siyue.leetcode.heapPriorityQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc347 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
        
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.topKFrequent(nums2, k2);
        System.out.println(Arrays.toString(result2));
    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> freqMap = new HashMap();
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            return freqMap.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue() - a.getValue())
                    .limit(k)
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
        }
    }
}
