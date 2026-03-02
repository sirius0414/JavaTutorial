package org.siyue.leetcode.binaryTree;

public class lc543 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        int result = solution.diameterOfBinaryTree(root);
        System.out.println(result);
        
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        int result2 = solution.diameterOfBinaryTree(root2);
        System.out.println(result2);
    }

    static class Solution {

        int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return maxDiameter;
        }

        public int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftDepth = dfs(node.left);
            int rightDepth = dfs(node.right);
            int diameter = leftDepth + rightDepth;
            // 更新全局最大直径
            maxDiameter = Math.max(maxDiameter, diameter);
            // 返回当前节点的深度
            return Math.max(leftDepth, rightDepth) + 1;
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
