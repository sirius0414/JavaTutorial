package org.siyue.leetcode.backtracking;

import java.util.*;

public class lc46 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        System.out.println(result);
        
        int[] nums2 = {0, 1};
        List<List<Integer>> result2 = solution.permute(nums2);
        System.out.println(result2);
        
        int[] nums3 = {1};
        List<List<Integer>> result3 = solution.permute(nums3);
        System.out.println(result3);
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            backtrack(nums);
            return result;
        }

        public void backtrack(int[] nums) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (visited.contains(nums[i])) {
                    continue; // 已经访问过，跳过
                }

                visited.add(nums[i]); // 标记为已访问
                path.add(nums[i]); // 选择当前元素，加入路径

                backtrack(nums); // 递归处理下一个元素

                path.remove(path.size() - 1); // 回退，撤销选择
                visited.remove(Integer.valueOf(nums[i])); // 标记为未访问
            }
        }
    }
}
