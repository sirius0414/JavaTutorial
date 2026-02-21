package org.siyue.leetcode.linkedList;

import java.util.HashSet;
import java.util.List;

public class lc142 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2; // 形成环，入口是node2
        ListNode result = solution.detectCycle(head);
        System.out.println(result != null ? result.val : "null");
        
        ListNode head2 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        head2.next = node22;
        node22.next = head2; // 形成环，入口是head2
        ListNode result2 = solution.detectCycle(head2);
        System.out.println(result2 != null ? result2.val : "null");
    }

    static class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            HashSet<ListNode> set = new HashSet<>();
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    while (!set.contains(slow)) {
                        set.add(slow);
                        slow = slow.next;
                    }
                    ListNode result = head;
                    while (!set.contains(result)) {
                        result = result.next;
                    }
                    return result;
                }
            }
            return null;
            //  O(1) 思路（Floyd）
            //	1.	用 slow 每次走 1 步，fast 每次走 2 步；
            //	2.	若相遇，说明有环；
            //	3.	让一个指针从 head 出发，另一个指针从相遇点出发，每次都走 1 步；
            //	4.	两者再次相遇的位置就是 入环点。
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
