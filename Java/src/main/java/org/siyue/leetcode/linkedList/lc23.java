package org.siyue.leetcode.linkedList;

public class lc23 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        ListNode[] lists = {
            new ListNode(1, new ListNode(4, new ListNode(5))),
            new ListNode(1, new ListNode(3, new ListNode(4))),
            new ListNode(2, new ListNode(6))
        };
        ListNode result = solution.mergeKLists(lists);
        printList(result);
        
        ListNode[] lists2 = {};
        ListNode result2 = solution.mergeKLists(lists2);
        printList(result2);
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
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
