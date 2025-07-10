package org.siyue.javatutorial.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CasBrokenDemo {

    private static final Unsafe unsafe;
    private static final long fieldOffset;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
            fieldOffset = unsafe.objectFieldOffset(CasBrokenDemo.class.getDeclaredField("a"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private volatile int a = 0;

    private final List<Integer> updates = Collections.synchronizedList(new ArrayList<>());

    // 错误逻辑：只有当 a == x - 1 时才能更新为 x
    private void increment(int x) {
        while (true) {
            if (unsafe.compareAndSwapInt(this, fieldOffset, x - 1, x)) {
                updates.add(x); // 记录成功写入的值
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int testRuns = 10000;
        int wrongOrderCount = 0;

        for (int i = 0; i < testRuns; i++) {
            CasBrokenDemo test = new CasBrokenDemo();
            CountDownLatch latch = new CountDownLatch(2);

            Thread t1 = new Thread(() -> {
                for (int j = 1; j <= 4; j++) {
                    test.increment(j);
                }
                latch.countDown();
            });

            Thread t2 = new Thread(() -> {
                for (int j = 5; j <= 9; j++) {
                    test.increment(j);
                }
                latch.countDown();
            });

            t1.start();
            t2.start();

            boolean finished = latch.await(1, java.util.concurrent.TimeUnit.SECONDS);

            if (!finished || !isSequential(test.updates)) {
                wrongOrderCount++;
                System.out.println("❌ Test " + i + " failed. Updates = " + test.updates);
            }
        }

        System.out.println("\n=== TEST COMPLETE ===");
        System.out.println("Total runs: " + testRuns);
        System.out.println("Non-sequential results: " + wrongOrderCount);
    }

    private static boolean isSequential(List<Integer> list) {
        if (list.size() != 9) return false;
        for (int i = 0; i < 9; i++) {
            if (list.get(i) != i + 1) return false;
        }
        return true;
    }
}
