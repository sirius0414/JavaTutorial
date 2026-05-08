package org.siyue.leetcode.backtracking;

import java.util.*;

public class lc131 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String s = "aab";
        List<List<String>> result = solution.partition(s);
        System.out.println(result);
        
        String s2 = "a";
        List<List<String>> result2 = solution.partition(s2);
        System.out.println(result2);
    }

    static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            List<String> path = new ArrayList<>();

            dfs(s, 0, path, result);

            return result;
        }

        private void dfs(String s, int start, List<String> path, List<List<String>> result) {
            // 如果 start 到达字符串末尾，说明已经完成一种合法切分
            if (start == s.length()) {
                result.add(new ArrayList<>(path));
                return;
            }

            // 枚举当前这一刀切到哪里
            for (int end = start; end < s.length(); end++) {
                // 判断 s[start...end] 是否是回文串
                if (!isPalindrome(s, start, end)) {
                    continue;
                }

                // 选择当前回文子串
                path.add(s.substring(start, end + 1));

                // 继续从 end + 1 的位置往后切
                dfs(s, end + 1, path, result);

                // 回溯，撤销选择
                path.remove(path.size() - 1);
            }
        }

        private boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }
    }
}
