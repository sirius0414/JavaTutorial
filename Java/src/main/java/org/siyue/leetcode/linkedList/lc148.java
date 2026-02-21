package org.siyue.leetcode.linkedList;

public class lc148 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode result = solution.sortList(head);
        printList(result);
        
        ListNode head2 = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ListNode result2 = solution.sortList(head2);
        printList(result2);
    }

    static class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;

            // 1) cut into two halves: [head..midPrev] and [mid..]
            ListNode mid = getMid(head);     // mid is start of right half
            ListNode left = head;
            ListNode right = mid;

            // 2) sort each half
            left = sortList(left);
            right = sortList(right);

            // 3) merge
            return merge(left, right);
        }

        // return start node of right half, and cut the list into two halves
        private ListNode getMid(ListNode head) {
            // slow/fast with "prev" to cut
            ListNode slow = head, fast = head, prev = null;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            // now slow is mid, prev is end of left half
            prev.next = null; // cut
            return slow;
        }

        private ListNode merge(ListNode a, ListNode b) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            while (a != null && b != null) {
                if (a.val <= b.val) {   // <= keeps stability
                    cur.next = a;
                    a = a.next;
                } else {
                    cur.next = b;
                    b = b.next;
                }
                cur = cur.next;
            }
            cur.next = (a != null) ? a : b;
            return dummy.next;
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
