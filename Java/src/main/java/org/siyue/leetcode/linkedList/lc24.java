package org.siyue.leetcode.linkedList;

public class lc24 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result = solution.swapPairs(head);
        printList(result);
        
        ListNode head2 = null;
        ListNode result2 = solution.swapPairs(head2);
        printList(result2);

        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode result3 = solution.swapPairs(head3);
        printList(result3);
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummyHead = new ListNode(0, head);

            if (head == null || head.next == null) {
                return head;
            }

            ListNode prev = head;
            ListNode curr = head.next;

            dummyHead.next = curr;

            while (curr != null && curr.next != null) {
                ListNode next = curr.next;
                ListNode nextNext = curr.next.next;

                // swap
                curr.next = prev;
                if (next.next != null) {
                    prev.next = nextNext;
                } else {
                    prev.next = next;
                }


                // move to the next pair
                prev = next;
                curr = prev.next;
            }

            if (curr != null) {
                // 置换最后一次
                curr.next = prev;
                prev.next = null;
            }

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
