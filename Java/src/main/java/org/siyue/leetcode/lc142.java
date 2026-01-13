package org.siyue.leetcode;

public class lc142 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2; // 形成环，入口是node2
        ListNode result = solution.detectCycle(head);
        System.out.println(result != null ? result.val : "null");
        
        ListNode head2 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        head2.next = node22;
        node22.next = head2; // 形成环，入口是head2
        ListNode result2 = solution.detectCycle(head2);
        System.out.println(result2 != null ? result2.val : "null");
    }

    static class Solution {
        public ListNode detectCycle(ListNode head) {
            // TODO: 实现方法
            return null;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
