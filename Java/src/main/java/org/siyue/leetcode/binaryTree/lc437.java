package org.siyue.leetcode.binaryTree;

import java.util.Arrays;
import java.util.HashMap;

public class lc437 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));
        int targetSum = 8;
        int result = solution.pathSum(root, targetSum);
        System.out.println(result);
        
        TreeNode root2 = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        int targetSum2 = 22;
        int result2 = solution.pathSum(root2, targetSum2);
        System.out.println(result2);
    }

    static class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            // 前缀和 每个节点都算自己的前缀和，然后放到HashMap中去
            // 想通过前缀和计算路径和，应该用当前节点的前缀和减去HashMap里所有存的key的前缀和，然后看看有多少符合要求的（也就是值）
            HashMap<Long, Integer> cnt = new HashMap<>();
            cnt.put(0L, 1); // 空前缀：curSum==target 时能被统计到
            return dfs(root, 0L, targetSum, cnt);
        }

        private int dfs(TreeNode node, long curSum, int targetSum, HashMap<Long, Integer> cnt) {
            if (node == null) return 0;

            curSum += node.val;

            int res = cnt.getOrDefault(curSum - targetSum, 0);

            cnt.put(curSum, cnt.getOrDefault(curSum, 0) + 1);

            res += dfs(node.left, curSum, targetSum, cnt);
            res += dfs(node.right, curSum, targetSum, cnt);

            // 回溯：撤销当前节点对路径前缀和计数的影响
            cnt.put(curSum, cnt.get(curSum) - 1);

            return res;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
