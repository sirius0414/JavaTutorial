package org.siyue.leetcode.backtracking;

import java.util.*;

public class lc78 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
        
        int[] nums2 = {0};
        List<List<Integer>> result2 = solution.subsets(nums2);
        System.out.println(result2);
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backTracking(nums, 0, new ArrayList<>(), result);
            return result;
        }

        public void backTracking(int[] nums, int i, List<Integer> path, List<List<Integer>> result) {
            if (i == nums.length) {
                // 终止条件：当start达到数组长度时，说明已经遍历完所有元素，此时将当前路径path加入结果result中
                result.add(new ArrayList<>(path));
                return;
            }

            path.add(nums[i]); // 选择当前元素，加入路径
            backTracking(nums, i + 1, path, result); // 递归处理下一个元素
            path.remove(path.size() - 1); // 回退，撤销选择

            backTracking(nums, i + 1, path, result); // 递归处理下一个元素，不选择当前元素
        }
    }
}
