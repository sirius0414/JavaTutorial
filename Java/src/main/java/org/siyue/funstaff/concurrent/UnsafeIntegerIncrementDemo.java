package org.siyue.funstaff.concurrent;

public class UnsafeIntegerIncrementDemo {
    static volatile Integer count = 0;

    /**
     *
     * @param args
     * @throws InterruptedException
     * 这个代码存在严重的同步错误，不仅线程不安全，还可能抛出异常
     * 这句 count++ 会创建一个新的 Integer 对象，并赋值给 count，导致：
     * 1. 锁对象本身在运行过程中不断改变；
     * 2. Thread t 和主线程加锁的是不同的对象（虽然名字一样）
     *
     * Integer.valueOf(int i) 是否会创建新对象，取决于 i 的值是否落在 缓存范围内
     * 如果 i 在 [-128, 127] 之间，会从缓存中返回已有对象（不会创建新对象 ）
     * 如果 i 超出这个范围，则会创建新的 Integer 实例
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (count) {
                    count++;
                }
            }
        });
        t.start();
        for (int i = 0; i < 10000; i++) {
            synchronized (count) {
                count++;
            }
        }

        t.join();
        System.out.println(count);
    }

}
