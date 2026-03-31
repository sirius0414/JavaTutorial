package org.siyue.leetcode.stack;

import java.util.Stack;

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
        // 可以扩展想想 O1额外空间要如何实现
        // hint；利用差值diff
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);

            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                minStack.push(Math.min(val, minStack.peek()));
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
