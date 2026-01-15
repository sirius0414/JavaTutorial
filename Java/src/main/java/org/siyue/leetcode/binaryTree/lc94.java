package org.siyue.leetcode;

import java.util.*;

public class lc94 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> result = solution.inorderTraversal(root);
        System.out.println(result);
        
        TreeNode root2 = null;
        List<Integer> result2 = solution.inorderTraversal(root2);
        System.out.println(result2);
    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            // TODO: 实现方法
            return new ArrayList<>();
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
