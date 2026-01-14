package org.siyue.leetcode;

public class lc155 {
    public static void main(String[] args) throws InterruptedException {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // 返回 -3
        minStack.pop();
        System.out.println(minStack.top());    // 返回 0
        System.out.println(minStack.getMin()); // 返回 -2
    }

    static class MinStack {
        public MinStack() {
            // TODO: 实现构造函数
        }

        public void push(int val) {
            // TODO: 实现方法
        }

        public void pop() {
            // TODO: 实现方法
        }

        public int top() {
            // TODO: 实现方法
            return 0;
        }

        public int getMin() {
            // TODO: 实现方法
            return 0;
        }
    }
}
