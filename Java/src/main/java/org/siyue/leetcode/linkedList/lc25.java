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
            if (head == null || k <= 1) return head;

            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;

            ListNode cur = head;
            ListNode prevGroupTail = dummyHead; // 用于把上一组尾巴接到这一组的新头

            while (cur != null) {
                // 判断是否还有 k 个节点，并拿到下一组的起点 nextGroup
                ListNode nextGroup = cur;
                for (int i = 0; i < k; i++) {
                    if (nextGroup == null) { // 不足 k 个，直接结束
                        return dummyHead.next;
                    }
                    nextGroup = nextGroup.next;
                }

                // 记录当前组翻转后的“尾巴”（翻转前的头）
                ListNode groupTail = cur;

                // 翻转当前组，拿到新头
                ListNode newHead = groupReversed(cur, k);

                // 把上一组尾巴接到本组新头
                prevGroupTail.next = newHead;

                // 翻转后本组的尾巴接到下一组（groupReversed 内部也会做，这里做也安全但重复）
                groupTail.next = nextGroup;

                // 移动到下一组
                prevGroupTail = groupTail;
                cur = nextGroup;
            }

            return dummyHead.next;
        }

        // 只翻转 k 个节点，返回翻转后的新头
        public ListNode groupReversed(ListNode head, int k) {
            // 先找到本组第 k 个节点（kth），用于作为返回的新头
            ListNode kth = head;
            for (int i = 1; i < k; i++) {
                kth = kth.next; // 外层已保证足够 k 个节点，这里不会 null
            }
            ListNode nextGroup = kth.next;

            // 经典区间翻转：把 [head, kth] 翻转，尾巴自动接到 nextGroup
            ListNode prev = nextGroup;
            ListNode cur = head;
            while (cur != nextGroup) {
                ListNode nxt = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nxt;
            }

            return kth; // 翻转后新头就是 kth
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
