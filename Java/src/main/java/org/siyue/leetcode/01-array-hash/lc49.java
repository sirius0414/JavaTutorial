package org.siyue.leetcode;

import java.util.*;

public class lc49 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {"dddddd", "dddddd", "ddddddg"};
        List<List<String>> result = solution.groupAnagrams(strs2);
        System.out.println(result);

    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> wordMap = new HashMap<>();

            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);

                wordMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            }

            return new ArrayList<>(wordMap.values());
        }
    }

}

