package org.siyue.leetcode.binaryTree;

public class lc104 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int result = solution.maxDepth(root);
        System.out.println(result);
        
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        int result2 = solution.maxDepth(root2);
        System.out.println(result2);
    }

    static class Solution {
        public int maxDepth(TreeNode root) {
            // TODO: 实现方法
            return 0;
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
