package org.siyue.leetcode;

public class lc15 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String[] str = new String[]{"flower","flow","flight"};
        String result = solution.longestCommonPrefix(str);
        System.out.println(result);
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            } else {
                String prefix = strs[0];
                Integer ptr = prefix.length();
                Solution.IntStringResult isr = new Solution.IntStringResult(ptr, prefix);
                for (int i = 0; i < strs.length; i++) {
                    isr = findPrefix(strs[i], ptr, prefix);
                    if (isr.number == -1) {
                        return "";
                    } else {
                        ptr = isr.number;
                        prefix = isr.text;
                    }
                }
                return isr.text;
            }
        }

        public Solution.IntStringResult findPrefix(String str, Integer ptr, String prefix) {
            int length = Math.min(prefix.length(),  str.length());
            String strCompare = str.substring(0, length);
            String prefixCompare = prefix.substring(0, length);

            while (strCompare.length() > 0) {
                if (strCompare.equals(prefixCompare)) {
                    prefixCompare = strCompare;
                    return new Solution.IntStringResult(ptr, prefixCompare);
                }
                strCompare = strCompare.substring(0,strCompare.length()-1);
                prefixCompare = prefixCompare.substring(0,prefixCompare.length()-1);
            }
            return new Solution.IntStringResult(-1, "");
        }

        public class IntStringResult {
            private final int number;
            private final String text;

            public IntStringResult(int number, String text) {
                this.number = number;
                this.text = text;
            }

            public int getNumber() { return number; }
            public String getText() { return text; }
        }
    }
}
