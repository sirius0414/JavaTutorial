package org.siyue.leetcode;

public class lc226 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode result = solution.invertTree(root);
        printTree(result);
        
        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode result2 = solution.invertTree(root2);
        printTree(result2);
    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            // TODO: 实现方法
            return null;
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

    static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.print(root.val + " ");
        if (root.left != null || root.right != null) {
            printTree(root.left);
            printTree(root.right);
        }
    }
}
