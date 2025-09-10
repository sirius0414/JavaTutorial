package org.siyue.javatutorial.concurrent;

public class FalseSharingContendedDemo {

    public static final int THREAD_COUNT = 4;
    public static final long ITERATIONS = 10_000_000L;

    // 对比用的数据结构
    public static class Data {
        public volatile long value = 0L;
    }

    // 填充防止伪共享的结构（JDK 8+ 可使用 @Contended）
    public static class PaddedData {
        public volatile long value = 0L;
        // padding 使每个变量独立占用一组缓存行
        public long p1, p2, p3, p4, p5, p6, p7;
    }

    public static void main(String[] args) throws InterruptedException {
        // 修改这里可选择是否使用 padding
        final Data[] array = new Data[THREAD_COUNT];
        // final PaddedData[] array = new PaddedData[THREAD_COUNT];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Data();
        }

        long start = System.nanoTime();
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                for (long j = 0; j < ITERATIONS; j++) {
                    array[index].value = j;
                }
            });
        }

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        long end = System.nanoTime();
        System.out.printf("Duration: %,d ns%n", end - start);
    }
}
