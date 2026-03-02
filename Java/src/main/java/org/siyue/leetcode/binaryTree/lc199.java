package org.siyue.leetcode.binaryTree;

import java.util.*;

public class lc199 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        List<Integer> result = solution.rightSideView(root);
        System.out.println(result);
        
        TreeNode root2 = new TreeNode(1, null, new TreeNode(3));
        List<Integer> result2 = solution.rightSideView(root2);
        System.out.println(result2);
    }

    static class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            list = bfs(root);
            List<Integer> res = new ArrayList<>();

            if(list == null) return res;

            res = list.stream().map(
                    l -> l.getLast()
            ).toList();
            return res;
        }

        // 层序遍历
        public List<List<Integer>> bfs(TreeNode root) {
            Queue<TreeNode> que = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();

            if (root == null) return result;

            que.offer(root);
            while (!que.isEmpty()) {
                int len = que.size();
                List<Integer> list = new ArrayList();
                for (int i = 0; i < len; i++){
                    TreeNode cur = que.poll();
                    list.add(cur.val);
                    // Add Child Nodes
                    if (cur.left != null) que.offer(cur.left);
                    if (cur.right != null) que.offer(cur.right);
                }
                result.add(list);
            }
            return result;
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
