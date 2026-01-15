package org.siyue.leetcode.binaryTree;

public class lc108 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode result = solution.sortedArrayToBST(nums);
        printTree(result);
        
        int[] nums2 = {1, 3};
        TreeNode result2 = solution.sortedArrayToBST(nums2);
        printTree(result2);
    }

    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
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
