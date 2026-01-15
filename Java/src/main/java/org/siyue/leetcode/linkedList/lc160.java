package org.siyue.leetcode.linkedList;

public class lc160 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        ListNode headA = new ListNode(4);
        ListNode headB = new ListNode(5);
        ListNode node1 = new ListNode(1);
        ListNode node8 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        headA.next = node1;
        node1.next = node8;
        node8.next = node4;
        node4.next = node5;
        headB.next = node8; // 相交节点是node8
        ListNode result = solution.getIntersectionNode(headA, headB);
        System.out.println(result != null ? result.val : "null");
        
        ListNode headA2 = new ListNode(2);
        ListNode headB2 = new ListNode(1);
        headA2.next = new ListNode(6);
        headA2.next.next = new ListNode(4);
        headB2.next = new ListNode(5);
        ListNode result2 = solution.getIntersectionNode(headA2, headB2);
        System.out.println(result2 != null ? result2.val : "null");
    }

    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
