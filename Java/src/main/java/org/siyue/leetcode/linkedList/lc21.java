package org.siyue.leetcode.linkedList;

public class lc21 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = solution.mergeTwoLists(list1, list2);
        printList(result);
        
        ListNode list3 = null;
        ListNode list4 = null;
        ListNode result2 = solution.mergeTwoLists(list3, list4);
        printList(result2);
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode p1 = list1, p2 = list2;
            ListNode p = new ListNode(0); // dummy head
            ListNode dummyHead = p;

            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;
            }

            while (p1 != null) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            }

            while (p2 != null) {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
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
