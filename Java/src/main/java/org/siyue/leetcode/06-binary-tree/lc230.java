package org.siyue.leetcode;

public class lc230 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        int k = 1;
        int result = solution.kthSmallest(root, k);
        System.out.println(result);
        
        TreeNode root2 = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        int k2 = 3;
        int result2 = solution.kthSmallest(root2, k2);
        System.out.println(result2);
    }

    static class Solution {
        public int kthSmallest(TreeNode root, int k) {
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
