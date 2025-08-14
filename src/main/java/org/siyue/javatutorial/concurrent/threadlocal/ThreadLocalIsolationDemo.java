package org.siyue.javatutorial.concurrent.threadlocal;

/**
 * 线程间隔离：不同线程的 reqId 不同。
 * 方法间共享：同一线程的 methodA 和 methodB 访问的是同一个 reqId，没有通过方法参数传递。
 */
public class ThreadLocalIsolationDemo {

    // ThreadLocal：同线程内共享，不同线程隔离
    private static final ThreadLocal<String> REQ_ID = ThreadLocal.withInitial(() -> null);

    public static void main(String[] args) {
        Runnable task = () -> {
            // 每个线程生成自己的 reqId
            String reqId = "REQ-" + System.nanoTime();
            REQ_ID.set(reqId);
            try {
                methodA();
            } finally {
                // 避免在线程池等复用场景下数据泄漏
                REQ_ID.remove();
            }
        };

        Thread t1 = new Thread(task, "worker-1");
        Thread t2 = new Thread(task, "worker-2");
        Thread t3 = new Thread(task, "worker-3");

        t1.start();
        t2.start();
        t3.start();
    }

    private static void methodA() {
        System.out.printf("[%s] methodA reqId=%s%n",
                Thread.currentThread().getName(), REQ_ID.get());
        methodB();
    }

    private static void methodB() {
        System.out.printf("[%s] methodB reqId=%s%n",
                Thread.currentThread().getName(), REQ_ID.get());
    }
}
