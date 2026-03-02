package org.siyue.leetcode.binaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class lc114 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        solution.flatten(root);
        printList(root);
        
        TreeNode root2 = null;
        solution.flatten(root2);
        printList(root2);
    }

    static class Solution {
        public void flatten(TreeNode root) {
            // 一次操作意味着把左node扩充到root和右node之间
            TreeNode cur = root;

            while (cur!=null) {
                if (cur.left!=null) {
                    // 找到左子树的最右节点
                    TreeNode pred = cur.left;
                    while (pred.right != null) {
                        pred = pred.right;
                    }
                    // 左子树的最右节点的下一个需要是父节点的右节点
                    pred.right = cur.right;
                    // 左子树接过来
                    cur.right = cur.left;
                    cur.left = null;
                }
                cur = cur.right;
            }
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

    static void printList(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
        System.out.println();
    }
}
