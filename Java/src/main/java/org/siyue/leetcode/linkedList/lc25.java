package org.siyue.leetcode.linkedList;

public class lc25 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;
        ListNode result = solution.reverseKGroup(head, k);
        printList(result);
        
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k2 = 3;
        ListNode result2 = solution.reverseKGroup(head2, k2);
        printList(result2);
    }

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            // TODO: 实现方法
            return null;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
