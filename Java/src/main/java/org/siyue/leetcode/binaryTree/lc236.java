package org.siyue.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

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
            List<TreeNode> pathP = new ArrayList<>();
            List<TreeNode> pathQ = new ArrayList<>();
            findPath(root, p, pathP);
            findPath(root, q, pathQ);

            int i = 0;
            while (i < pathP.size() && i < pathQ.size() && pathP.get(i) == pathQ.get(i)) {
                i++;
            }
            return pathP.get(i - 1);
        }

        private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
            if (root == null) return false;

            path.add(root);
            if (root == target) return true;

            if (findPath(root.left, target, path) || findPath(root.right, target, path)) {
                return true;
            }

            // 回溯：这条路不通，撤销
            path.remove(path.size() - 1);
            return false;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public TreeNode(int x, TreeNode treeNode, TreeNode treeNode1) {
            this.val = x;
            this.left = treeNode;
            this.right = treeNode1;
        }
    }
}
