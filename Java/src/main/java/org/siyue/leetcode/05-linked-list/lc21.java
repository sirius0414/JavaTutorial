package org.siyue.leetcode;

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
