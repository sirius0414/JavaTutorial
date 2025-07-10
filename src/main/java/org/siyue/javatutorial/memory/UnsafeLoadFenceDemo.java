package org.siyue.javatutorial.memory;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

/**
 * loadFence()' is deprecated since version 22 and marked for removal
 *
 * This example demonstrates the use of Unsafe.loadFence() to ensure that
 * the main thread observes the changes made by a child thread
 * without reordering memory operations.
 *
 */
public class UnsafeLoadFenceDemo {

    static class Data {
        boolean flag = false;
    }

    private static final Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException("Cannot access Unsafe", e);
        }
    }

    public static void main(String[] args) {
        Data data = new Data();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.flag = true;
            System.out.println("Child Thread set flag=true");
        }).start();

        while (true) {
            boolean flag = data.flag;
            unsafe.loadFence();  // 插入读内存屏障
            if (flag) {
                System.out.println("Main Thread observed flag=true");
                break;
            }
        }

        System.out.println("End");
    }
}
