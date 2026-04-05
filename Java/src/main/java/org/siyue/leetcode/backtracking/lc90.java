package org.siyue.leetcode.backtracking;

import java.util.*;

public class lc90 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        System.out.println(result);

        int[] nums2 = {0};
        List<List<Integer>> result2 = solution.subsetsWithDup(nums2);
        System.out.println(result2);
    }

    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums); // 先排序，方便后续去重
            backTracking(nums, 0, new ArrayList<>(), result);
            return result;
        }

        public void backTracking(int[] nums, int i, List<Integer> path, List<List<Integer>> result) {

            result.add(new ArrayList<>(path));

                for (int j = i; j < nums.length; j++) {
                    if (j > i && nums[j] == nums[j - 1]) {
                        continue; // 跳过重复元素
                    }
                    path.add(nums[j]); // 选择当前元素，加入路径
                    backTracking(nums, j + 1, path, result); // 递归处理下一个元素
                    path.remove(path.size() - 1); // 回退，撤销选择
                }
        }
    }
}
