package org.siyue.javatutorial.concurrent;

public class SynchronizedDemo {
    public synchronized void syncMethod() {
        System.out.println("Hello from sync method");
    }

    public void syncBlock() {
        synchronized (this) {
            System.out.println("Hello from sync block");
        }
    }

    public static void main(String[] args) {
        new SynchronizedDemo().syncMethod();
        new SynchronizedDemo().syncBlock();
    }
}
