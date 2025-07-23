package org.siyue.javatutorial.concurrent;

public class NotifyDemo {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        Thread waiter = new Thread(() -> {
            synchronized (lockA) {
                try {
                    System.out.println("Thread A: waiting...");
                    lockA.wait();  // 进入 WAITING，释放锁
                    System.out.println("Thread A: resumed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread notifier = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Thread B: notifying...");
                lockA.notify(); // 被唤醒线程进入 BLOCKED，等待重新获取锁
                try {
                    Thread.sleep(3000); // 故意延迟释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread B: finished, now releasing lock");
            }
        });

        try{
            waiter.start();
            Thread.sleep(1000);
            notifier.start();
        } catch (IllegalMonitorStateException | InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }

    }
}
