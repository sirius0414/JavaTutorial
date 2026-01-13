package org.siyue.leetcode;

public class lc207 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        boolean result = solution.canFinish(numCourses, prerequisites);
        System.out.println(result);
        
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        boolean result2 = solution.canFinish(numCourses2, prerequisites2);
        System.out.println(result2);
    }

    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // TODO: 实现方法
            return false;
        }
    }
}
