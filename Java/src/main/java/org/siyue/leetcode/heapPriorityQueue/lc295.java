package org.siyue.leetcode.heapPriorityQueue;

import java.util.PriorityQueue;

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

        // 核心的存储结构应该是两个堆 Lower-half & Higher-half
        // PQ 默认的Comparator是自然顺序，所以默认是小顶堆
        PriorityQueue<Integer> pq_hi = new PriorityQueue<>();
        // 需要一个大顶堆来存储较小的一半元素，Java中可以通过反转Comparator来实现
        PriorityQueue<Integer> pq_lo = new PriorityQueue<>((a, b) -> b - a);

        public MedianFinder() {
        }

        public void addNum(int num) {
            // 先将新元素添加到合适的堆中
            if (pq_lo.isEmpty() || num <= pq_lo.peek()) {
                pq_lo.offer(num);
            } else {
                pq_hi.offer(num);
            }
            // 再判断两个堆的大小，保持平衡
            if (pq_lo.size() > pq_hi.size() + 1) {
                pq_hi.offer(pq_lo.poll());
            } else if (pq_hi.size() > pq_lo.size() + 1) {
                pq_lo.offer(pq_hi.poll());
            }
        }

        public double findMedian() {
            int len_hi = pq_hi.size();
            int len_lo = pq_lo.size();

            if (len_lo > len_hi) {
                return pq_lo.peek();
            } else if (len_hi > len_lo) {
                return pq_hi.peek();
            } else {
                return (pq_lo.peek() + pq_hi.peek()) / 2.0;
            }
        }
    }
}
