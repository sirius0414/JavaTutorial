package org.siyue.leetcode.binaryTree;

public class lc236 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        TreeNode p = root.left; // 5
        TreeNode q = root.right; // 1
        TreeNode result = solution.lowestCommonAncestor(root, p, q);
        System.out.println(result != null ? result.val : "null");
        
        TreeNode p2 = root.left; // 5
        TreeNode q2 = root.left.right.right; // 4
        TreeNode result2 = solution.lowestCommonAncestor(root, p2, q2);
        System.out.println(result2 != null ? result2.val : "null");
    }

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // TODO: 实现方法
            return null;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
