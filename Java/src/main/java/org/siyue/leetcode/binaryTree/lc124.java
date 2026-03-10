package org.siyue.leetcode.binaryTree;

public class lc124 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int result = solution.maxPathSum(root);
        System.out.println(result);
        
        TreeNode root2 = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int result2 = solution.maxPathSum(root2);
        System.out.println(result2);
    }

    static class Solution {
        int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }

            // 左右子树对当前节点的最大贡献，负数就不要
            int leftGain = Math.max(dfs(node.left), 0);
            int rightGain = Math.max(dfs(node.right), 0);

            // 以当前节点为“拐点”的最大路径和
            int currentPathSum = node.val + leftGain + rightGain;

            // 更新全局答案
            ans = Math.max(ans, currentPathSum);

            // 返回给父节点的最大单边贡献
            return node.val + Math.max(leftGain, rightGain);
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
