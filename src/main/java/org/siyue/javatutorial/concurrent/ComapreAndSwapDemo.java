package org.siyue.javatutorial.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 演示使用 Unsafe 实现的 CAS 顺序打印示例。
 * 运行后，两个线程将协作打印数字 1 到 9，顺序不乱。
 */
public class ComapreAndSwapDemo {

    private volatile int a = 0; // 共享变量
    private static final Unsafe unsafe;
    private static final long fieldOffset;

    static {
        try {
            // 获取 Unsafe 实例
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);

            // 获取字段偏移量
            fieldOffset = unsafe.objectFieldOffset(ComapreAndSwapDemo.class.getDeclaredField("a"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Unsafe or field offset", e);
        }
    }

    public static void main(String[] args) {
        ComapreAndSwapDemo comapreAndSwapDemo = new ComapreAndSwapDemo();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 4; i++) {
                comapreAndSwapDemo.incrementAndPrint(i);
            }
        }, "T1");

        Thread t2 = new Thread(() -> {
            for (int i = 5; i <= 9; i++) {
                comapreAndSwapDemo.incrementAndPrint(i);
            }
        }, "T2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n执行完毕");
    }

    private void incrementAndPrint(int targetValue) {
        while (true) {
            int currentValue = a;
            if (currentValue == targetValue - 1) {
                if (unsafe.compareAndSwapInt(this, fieldOffset, currentValue, targetValue)) {
                    System.out.print(targetValue + " ");
                    break;
                }
            }
            Thread.yield();
        }
    }
}
