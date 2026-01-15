package org.siyue.leetcode.linkedList;

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
        public LRUCache(int capacity) {
            // TODO: 实现构造函数
        }

        public int get(int key) {
            // TODO: 实现方法
            return -1;
        }

        public void put(int key, int value) {
            // TODO: 实现方法
        }
    }
}
