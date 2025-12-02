package org.siyue.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc17 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String digits = "23";
        List<String> result = solution.letterCombinations(digits);
        System.out.println(result);
    }

    static class Solution {
        public List<String> letterCombinations(String digits) {
            Map<String, List<String>> combMapping = new HashMap<>();

            combMapping.put("2", new ArrayList<>(List.of("a", "b", "c")));
            combMapping.put("3", new ArrayList<>(List.of("d", "e", "f")));
            combMapping.put("4", new ArrayList<>(List.of("g", "h", "i")));
            combMapping.put("5", new ArrayList<>(List.of("j", "k", "l")));
            combMapping.put("6", new ArrayList<>(List.of("m", "n", "o")));
            combMapping.put("7", new ArrayList<>(List.of("p", "q", "r", "s")));
            combMapping.put("8", new ArrayList<>(List.of("t", "u", "v")));
            combMapping.put("9", new ArrayList<>(List.of("w", "x", "y", "z")));

            List<String> result = combMapping.get(String.valueOf(digits.charAt(0)));

            for (int i = 1; i < digits.length(); i++) {
                result = weaving(result, combMapping.get(String.valueOf(digits.charAt(i))));
            }

            return result;
        }

        private List<String> weaving(List<String> str1, List<String> str2) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < str1.size(); i++) {
                for (int j = 0; j < str2.size(); j++) {
                    result.add(str1.get(i) + str2.get(j));
                }
            }
            return result;
        }
    }
}
