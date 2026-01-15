package org.siyue.leetcode.linkedList;

public class lc141 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2; // 形成环
        boolean result = solution.hasCycle(head);
        System.out.println(result);
        
        ListNode head2 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        head2.next = node22;
        node22.next = head2; // 形成环
        boolean result2 = solution.hasCycle(head2);
        System.out.println(result2);
        
        ListNode head3 = new ListNode(1);
        boolean result3 = solution.hasCycle(head3);
        System.out.println(result3);
    }

    static class Solution {
        public boolean hasCycle(ListNode head) {
            // TODO: 实现方法
            return false;
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
