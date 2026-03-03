package org.siyue.leetcode.binaryTree;

import java.util.*;

public class lc105 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode result = solution.buildTree(preorder, inorder);
        printTree(result);
        
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode result2 = solution.buildTree(preorder2, inorder2);
        printTree(result2);
    }

    static class Solution {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            TreeNode root = new TreeNode(preorder[0]);
            return build(preorder, inorder, root);
        }

        public TreeNode build(int[] preorder, int[] inorder, TreeNode root) {

            if (preorder.length == 0 || inorder.length == 0) {
                return null;
            }

            int root_val = preorder[0];
            root.val = root_val;

            // 左右子树的长度
            int find_root = 0;
            while (inorder[find_root] != root_val) {
                find_root++;
            }
            int len_left = find_root;
            int len_right = inorder.length - len_left - 1;

            // 找到左右子树的值
            if (len_left != 0) {
                root.left = new TreeNode(preorder[1]);
                // 左子树：新的preorder 和 inorder数组
                int[] l_preorder = Arrays.copyOfRange(preorder, 1, len_left+1);
                int[] l_inorder = Arrays.copyOfRange(inorder, 0, len_left);
                // 对子树继续build root.left is new root
                build(l_preorder, l_inorder, root.left);
            }
            if (len_right != 0) {
                root.right = new TreeNode(preorder[len_left+1]);
                // 右子树：新的preorder 和 inorder数组
                int[] r_preorder = Arrays.copyOfRange(preorder, len_left+1, len_left+len_right+1);
                int[] r_inorder = Arrays.copyOfRange(inorder, len_left+1, len_left+len_right+1);
                build(r_preorder, r_inorder, root.right);
            }

            return root;
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

    static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.print(root.val + " ");
        if (root.left != null || root.right != null) {
            printTree(root.left);
            printTree(root.right);
        }
    }
}
