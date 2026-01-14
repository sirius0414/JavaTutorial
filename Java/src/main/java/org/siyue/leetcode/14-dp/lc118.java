package org.siyue.leetcode;

import java.util.*;

public class lc118 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int numRows = 5;
        List<List<Integer>> result = solution.generate(numRows);
        System.out.println(result);
        
        int numRows2 = 1;
        List<List<Integer>> result2 = solution.generate(numRows2);
        System.out.println(result2);
    }

    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            // TODO: 实现方法
            return new ArrayList<>();
        }
    }
}
