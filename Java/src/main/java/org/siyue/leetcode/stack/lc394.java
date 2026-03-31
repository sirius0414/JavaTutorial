package org.siyue.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc394 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String s = "3[a]2[bc]";
        String result = solution.decodeString(s);
        System.out.println(result);
        
        String s2 = "3[a2[c]]";
        String result2 = solution.decodeString(s2);
        System.out.println(result2);
        
        String s3 = "2[abc]3[cd]ef";
        String result3 = solution.decodeString(s3);
        System.out.println(result3);
    }

    static class Solution {
        public String decodeString(String s) {
            Stack<Integer> countStack = new Stack<>();
            Stack<StringBuilder> strStack = new Stack<>();

            StringBuilder curr = new StringBuilder();
            int num = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (Character.isDigit(c)) {
                    // 如果遇到数字，就连续读取完整的数字，直到遇到非数字字符为止
                    num = num * 10 + (c - '0');
                } else if (c == '[') {
                    // 如果遇到左括号，就将当前的数字和字符串入栈，并重置它们以准备处理新的子串
                    countStack.push(num);
                    strStack.push(curr);

                    num = 0;
                    curr = new StringBuilder();
                } else if (c == ']') {
                    // 如果遇到右括号，就从栈顶弹出数字和字符串，并将当前的字符串重复相应的次数后与之前的字符串连接起来
                    int repeatTimes = countStack.pop();
                    StringBuilder prev = strStack.pop();

                    for (int j = 0; j < repeatTimes; j++) {
                        prev.append(curr);
                    }
                    curr = prev;
                } else {
                    // 如果遇到字母，就将它们添加到当前的字符串中
                    curr.append(c);
                }
            }

            return curr.toString();
        }
    }
}
