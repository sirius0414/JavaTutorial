package org.siyue.leetcode.binaryTree;

public class lc437 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));
        int targetSum = 8;
        int result = solution.pathSum(root, targetSum);
        System.out.println(result);
        
        TreeNode root2 = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        int targetSum2 = 22;
        int result2 = solution.pathSum(root2, targetSum2);
        System.out.println(result2);
    }

    static class Solution {
        public int pathSum(TreeNode root, int targetSum) {
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
