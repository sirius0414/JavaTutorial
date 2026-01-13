package org.siyue.leetcode;

public class lc19 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        ListNode result = solution.removeNthFromEnd(head, n);
        printList(result);
        
        ListNode head2 = new ListNode(1);
        int n2 = 1;
        ListNode result2 = solution.removeNthFromEnd(head2, n2);
        printList(result2);
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
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
