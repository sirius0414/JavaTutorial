package org.siyue.leetcode.binaryTree;

public class lc101 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        boolean result = solution.isSymmetric(root);
        System.out.println(result);
        
        TreeNode root2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        boolean result2 = solution.isSymmetric(root2);
        System.out.println(result2);
    }

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root.left == null && root.right == null) {
                return true;
            }
            if (root.left == null || root.right == null) {
                return false;
            }
            return dfs(root.left, root.right, true);
        }

        public boolean dfs(TreeNode left, TreeNode right, boolean isSymmetric) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return dfs(left.left, right.right, isSymmetric) && dfs(left.right, right.left, isSymmetric);
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
