package org.siyue.leetcode;

public class lc138 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        
        Node result = solution.copyRandomList(head);
        printList(result);
    }

    static class Solution {
        public Node copyRandomList(Node head) {
            // TODO: 实现方法
            return null;
        }
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print("[" + head.val + ",");
            if (head.random != null) {
                System.out.print(head.random.val);
            } else {
                System.out.print("null");
            }
            System.out.print("] ");
            head = head.next;
        }
        System.out.println();
    }
}
