package org.siyue.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

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
            ArrayList list = new ArrayList<>();
            inorderTraversal(root, list);
            // 判断中序递归返回的List是否有序
            for (int i = 1; i < list.size(); i++) {
                if ((Integer)list.get(i) <= (Integer)list.get(i - 1)) {
                    return false;
                }
            }
            return true;
        }

        // 中序递归
        public void inorderTraversal(TreeNode node, List<Integer> list) {
            if (node == null) {
                return ;
            }
            inorderTraversal(node.left, list);
            list.add(node.val);
            inorderTraversal(node.right, list);
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
