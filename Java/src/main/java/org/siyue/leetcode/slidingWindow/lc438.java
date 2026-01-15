package org.siyue.leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lc438 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String s = "aa";
        String p = "bb";
        System.out.println(solution.findAnagrams(s, p));
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            HashMap<Character, Integer> pMap = new HashMap<>();
            List<Integer> result = new ArrayList<>();

            if (s.length() < p.length()) {
                return result;
            }

            // Standard HashSet:
            for (char c : p.toCharArray()) {
                pMap.put(c, pMap.getOrDefault(c, 0) + 1);
            }

            HashMap<Character, Integer> sMap = new HashMap<>();

            for (int i = 0; i < p.length(); i++) {
                sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            }

            for (int i = 0; i <= s.length() - p.length(); i++) {
                if (sMap.equals(pMap)) {
                    result.add(i);
                }
                if (i + p.length() < s.length()) {
                    if (sMap.get(s.charAt(i)) > 1) {
                        sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) - 1);
                    } else {
                        sMap.remove(s.charAt(i));
                    }
                    char key = s.charAt(i + p.length());
                    sMap.put(key, sMap.getOrDefault(key, 0) + 1);
                }
            }
            return result;
        }
    }
}
