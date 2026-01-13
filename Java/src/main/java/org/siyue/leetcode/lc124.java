package org.siyue.leetcode;

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
        public int maxPathSum(TreeNode root) {
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
