package org.siyue.javatutorial.concurrent;

public class InterruptBlockingMethodDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                System.out.println("Thread sleeping...");
                Thread.sleep(5000);
                System.out.println("Woke up normally.");
            } catch (InterruptedException e) {
                System.out.println("Caught InterruptedException.");
                // 如果你什么都不做，线程会继续往下执行
            }

            System.out.println("Thread still running...");
        });

        t.start();
        Thread.sleep(1000); // 主线程稍等1秒
        t.interrupt();      // 中断子线程
    }
}

