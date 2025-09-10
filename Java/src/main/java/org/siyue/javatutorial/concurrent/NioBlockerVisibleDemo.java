package org.siyue.javatutorial.concurrent;

import java.lang.reflect.Field;
import java.nio.channels.Selector;

public class NioBlockerVisibleDemo {

    public static void main(String[] args) throws Exception {
        // 创建 selector 阻塞线程
        Thread nioThread = new Thread(() -> {
            try (Selector selector = Selector.open()) {
                System.out.println("NIO thread blocking on select()...");
                selector.select(); // 阻塞
            } catch (Exception e) {
                System.out.println("NIO thread interrupted: " + e);
            }
        }, "NioThread");

        nioThread.start();

        // 主线程每 200ms 查看一次 nioblocker
        Field nioBlockerField = Thread.class.getDeclaredField("nioBlocker");
        nioBlockerField.setAccessible(true);

        for (int i = 0; i < 20; i++) {
            Object blocker = nioBlockerField.get(nioThread);
            System.out.printf("[%d] nioBlocker: %s%n", i, blocker);
            Thread.sleep(200);
        }

        // 中断 NIO 线程
        System.out.println(">> Interrupting NioThread...");
        nioThread.interrupt();
        nioThread.join();
    }
}
