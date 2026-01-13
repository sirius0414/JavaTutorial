package org.siyue.leetcode;

import java.util.*;

public class lc763 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = solution.partitionLabels(s);
        System.out.println(result);
        
        String s2 = "eccbbbbdec";
        List<Integer> result2 = solution.partitionLabels(s2);
        System.out.println(result2);
    }

    static class Solution {
        public List<Integer> partitionLabels(String s) {
            // TODO: 实现方法
            return new ArrayList<>();
        }
    }
}
