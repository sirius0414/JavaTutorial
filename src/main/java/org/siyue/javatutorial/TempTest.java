package org.siyue.javatutorial;

import java.util.Date;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class TempTest {
    public static void main(String[] args) throws InterruptedException {
        AbstractQueuedSynchronizer aqs = new AbstractQueuedSynchronizer() {
            @Override
            protected boolean tryAcquire(int arg) {
                return false;
            }

            @Override
            protected boolean tryRelease(int arg) {
                return false;
            }
        };
        System.out.println("AbstractQueuedSynchronizer created: " + aqs);
        ReentrantLock reentrantLock = new ReentrantLock();
    }
}
