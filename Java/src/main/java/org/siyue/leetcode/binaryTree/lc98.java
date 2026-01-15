package org.siyue.leetcode;

public class lc98 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean result = solution.isValidBST(root);
        System.out.println(result);
        
        TreeNode root2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        boolean result2 = solution.isValidBST(root2);
        System.out.println(result2);
    }

    static class Solution {
        public boolean isValidBST(TreeNode root) {
            // TODO: 实现方法
            return false;
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
