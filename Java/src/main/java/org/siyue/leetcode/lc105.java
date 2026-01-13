package org.siyue.leetcode;

import java.util.*;

public class lc105 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode result = solution.buildTree(preorder, inorder);
        printTree(result);
        
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode result2 = solution.buildTree(preorder2, inorder2);
        printTree(result2);
    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
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
