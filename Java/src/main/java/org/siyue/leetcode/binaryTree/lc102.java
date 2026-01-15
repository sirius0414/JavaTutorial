package org.siyue.leetcode.binaryTree;

import java.util.*;

public class lc102 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
        
        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> result2 = solution.levelOrder(root2);
        System.out.println(result2);
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
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
