package org.siyue.leetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

public class lc146 {
    public static void main(String[] args) throws InterruptedException {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // 返回 1
        lruCache.put(3, 3); // 该操作会使得关键字 2 作废
        System.out.println(lruCache.get(2)); // 返回 -1 (未找到)
        lruCache.put(4, 4); // 该操作会使得关键字 1 作废
        System.out.println(lruCache.get(1)); // 返回 -1 (未找到)
        System.out.println(lruCache.get(3)); // 返回 3
        System.out.println(lruCache.get(4)); // 返回 4
    }

    static class LRUCache {
        // Capacity
        private final Integer capacity;
        private Integer currentSize = 0;
        // Key-ListNode Pairing
        private HashMap<Integer, DuoListNode> map = new HashMap<>();

        // 用一个类似于LinkedHashMap的数据结构实现就可以
        public static class DuoListNode {
            Integer key;
            Integer value;
            DuoListNode next;
            DuoListNode pre;

            DuoListNode(Integer key, Integer value) {
                this.key = key;
                this.value = value;
            }
        }

        // ListNodes
        public DuoListNode head = new DuoListNode(-1, 0);
        public DuoListNode tail = new DuoListNode(-1, 0);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            // Find DuoListNode with Key
            if (map.get(key) == null) {
                return -1;
            } else {
                DuoListNode node = map.get(key);
                // Move node
                DuoListNode pre = node.pre;
                DuoListNode next = node.next;
                pre.next = next;
                next.pre = pre;

                // To First
                DuoListNode temp = head.next;
                temp.pre = node;
                head.next = node;

                node.pre = head;
                node.next = temp;
                // return value
                return node.value;
            }
        }

        public void put(int key, int value) {
            DuoListNode node = new DuoListNode(key, value);
            if (capacity == 0) return;
            // If Update
            if (map.containsKey(key)) {
                node = map.get(key);
                node.value = value;
                // Move Node
                DuoListNode pre = node.pre;
                DuoListNode next = node.next;
                pre.next = next;
                next.pre = pre;
                // Add to Head
                DuoListNode temp = head.next;
                head.next = node;
                node.pre = head;
                node.next = temp;
                temp.pre = node;
            } else {
                // then Insert, Find if exceed the size
                if (currentSize >= capacity) {
                    // Pop out Last Node
                    DuoListNode del = tail.pre;
                    // Drop HashMap
                    map.remove(del.key);
                    // Pop out node
                    del.pre.next = tail;
                    tail.pre = del.pre;
                    currentSize -= 1;
                }
                // update HashMap
                map.put(key, node);

                // Add new Node at First
                DuoListNode temp = head.next;
                head.next = node;
                node.pre = head;
                node.next = temp;
                temp.pre = node;
                currentSize++;
            }
        }
    }
}
