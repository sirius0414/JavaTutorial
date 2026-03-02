package org.siyue.leetcode.binaryTree;

public class lc2415 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode result = solution.reverseOddLevels(root);
        printTree(result);

        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode result2 = solution.reverseOddLevels(root2);
        printTree(result2);
    }

    static class Solution {
        public TreeNode reverseOddLevels(TreeNode root) {
            // 这个傻逼题的意思不是反转树的结构，而是反转树的值

//            if (root == null) {
//                return null;
//            }
//            int depth = depthCount(root);
//            if (depth % 2 == 1) {
//                // Need to reverse the values of the current level
//                TreeNode left = reverseOddLevels(root.left);
//                root.left = reverseOddLevels(root.right);
//                root.right = left;
//                return root;
//            } else {
//                // Just go to the next level
//                root.left = reverseOddLevels(root.left);
//                root.right = reverseOddLevels(root.right);
//                return root;
//            }

            dfs(root.left, root.right, 1);
            return root;
        }

        public int depthCount(TreeNode node){
            if (node == null) {
                return 0;
            } else {
                return Math.max(depthCount(node.left), depthCount(node.right)) + 1;
            }
        }

        public void dfs(TreeNode left, TreeNode right, int layer) {
                if (left == null || right == null) {
                    return;
                }
                if (layer % 2 == 1) {
                    int temp = left.val;
                    left.val = right.val;
                    right.val = temp;
                }
                dfs(left.left, right.right, layer + 1);
                dfs(left.right, right.left, layer + 1);
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
