package org.siyue.javatutorial.concurrent;

public class UnsynchronizedDemo {

    private int sum = 0;

    /**
     * 不加 Sync
     */
    public void unsafeCalculate() {
        setSum(getSum() + 1); // 没有加 synchronized，存在竞态
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int value) {
        this.sum = value;
    }

    /**
     *
     * @param args
     * @throws InterruptedException
     * synchronisedCalculate() 使用 synchronized 关键字保证了对 sum 的更新是原子性的，防止竞态条件
     * 如果不加 synchronized，多线程执行时可能会出现结果小于 100000 的情况。
     *
     */
    public static void main(String[] args) throws InterruptedException {
        UnsynchronizedDemo demo = new UnsynchronizedDemo();

        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    demo.unsafeCalculate();
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        // 结果通常小于 100000，说明线程不安全
        System.out.println("Final sum (unsynchronized): " + demo.getSum());
    }
}

