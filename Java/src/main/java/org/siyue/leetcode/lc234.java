package org.siyue.leetcode;

public class lc234 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        boolean result = solution.isPalindrome(head);
        System.out.println(result);
        
        ListNode head2 = new ListNode(1, new ListNode(2));
        boolean result2 = solution.isPalindrome(head2);
        System.out.println(result2);
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            // TODO: 实现方法
            return false;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
