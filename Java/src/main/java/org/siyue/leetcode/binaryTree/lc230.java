package org.siyue.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

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
            ArrayList<Integer> list = new ArrayList<>();
            Integer ans = inorderTraversal(root, list, k);
            // 题目通常保证 k 合法；否则这里需要处理 ans==null
            return ans;
        }

        public Integer inorderTraversal(TreeNode node, List<Integer> list, int k) {
            if (node == null) return null;

            Integer left = inorderTraversal(node.left, list, k);
            if (left != null) return left;          // ✅ 左边找到就立刻返回

            list.add(node.val);
            if (list.size() == k) return node.val;  // ✅ 当前就是第 k 个，立刻返回

            return inorderTraversal(node.right, list, k); // ✅ 只在没找到时才去右边
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
