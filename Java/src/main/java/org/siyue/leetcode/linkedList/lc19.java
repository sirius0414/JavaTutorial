package org.siyue.leetcode.linkedList;

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
            ListNode dummyHead = new ListNode(0, head);
            ListNode slow = dummyHead;
            ListNode fast = dummyHead;

            for (int i = 0; i < n + 1; i++) {
                fast = fast.next;
            }

            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next.next;

            return dummyHead.next;
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
