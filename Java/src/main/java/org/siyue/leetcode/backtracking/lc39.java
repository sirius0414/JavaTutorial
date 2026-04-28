package org.siyue.leetcode.backtracking;

import java.util.*;

public class lc39 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println(result);
        
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        List<List<Integer>> result2 = solution.combinationSum(candidates2, target2);
        System.out.println(result2);
    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(candidates, target,0, result, path);
            return result;
        }

        void dfs(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> path) {
                if (target == 0) {
                    // target的剩余值为0，说明当前路径的和等于目标值，将当前路径加入结果集
                    result.add(new ArrayList<>(path));
                    return;
                }

                for (int i = index; i < candidates.length; i++) {
                    if (candidates[i] > target) {
                        continue; // 当前元素大于目标值，超了，跳过
                    }

                    path.add(candidates[i]); // 选择当前元素，加入路径
                    dfs(candidates, target - candidates[i], i, result, path); // 递归处理剩余目标值

                    path.remove(path.size() - 1); // 回退，撤销选择
                }
        }
    }
}
