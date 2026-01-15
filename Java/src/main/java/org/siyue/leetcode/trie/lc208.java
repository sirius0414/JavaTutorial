package org.siyue.leetcode.trie;

public class lc208 {
    public static void main(String[] args) throws InterruptedException {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }

    static class Trie {
        public Trie() {
            // TODO: 实现构造函数
        }

        public void insert(String word) {
            // TODO: 实现方法
        }

        public boolean search(String word) {
            // TODO: 实现方法
            return false;
        }

        public boolean startsWith(String prefix) {
            // TODO: 实现方法
            return false;
        }
    }
}
