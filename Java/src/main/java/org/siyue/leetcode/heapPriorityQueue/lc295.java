package org.siyue.leetcode.heapPriorityQueue;

public class lc295 {
    public static void main(String[] args) throws InterruptedException {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // 返回 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // 返回 2.0
    }

    static class MedianFinder {
        public MedianFinder() {
            // TODO: 实现构造函数
        }

        public void addNum(int num) {
            // TODO: 实现方法
        }

        public double findMedian() {
            // TODO: 实现方法
            return 0.0;
        }
    }
}
