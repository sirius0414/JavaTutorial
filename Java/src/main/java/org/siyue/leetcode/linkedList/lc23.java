package org.siyue.leetcode.linkedList;

import java.util.ArrayList;
import java.util.HashMap;

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
            // 1. Construct a ArrayList of Nodes Pointers, the k-th Pointer points to K-th Lists
            ArrayList<ListNode> pointers = new ArrayList<>();
            for (ListNode node : lists) {
                if (node != null) pointers.add(node); // 过滤 null
            }
            boolean empty_flag = false;

            ListNode result_tail = new ListNode(0);
            ListNode result = result_tail;
            // 2. while node is not all nulls
            while (!pointers.isEmpty()) {
                int min = Integer.MAX_VALUE;
                int minPos = 0;
                for (int i = 0; i < pointers.size(); i++) {
                    // Find min Value of these pointers
                    if (pointers.get(i).val < min) {
                        // Min Value is at Pos i
                        min = pointers.get(i).val;
                        minPos = i;
                    }
                }
                // Put the i-th node into result
                result_tail.next = pointers.get(minPos);
                result_tail = result_tail.next;

                // Then move corresponding Pointer
                pointers.set(minPos, pointers.get(minPos).next);

                // Examine if any pointer in list pointers has null next, then remove
                if (pointers.get(minPos) == null) {
                    pointers.remove(minPos);
                }
            }

            return result.next;
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
