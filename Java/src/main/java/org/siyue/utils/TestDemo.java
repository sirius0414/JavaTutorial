package org.siyue.utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Only a demo class for demonstration the bytecode of a class implementing Lock interface
public class TestDemo implements Lock {

    private Integer num;

    private String str;

    public TestDemo(Integer num, String str) {
        this.num = num;
        this.str = str;
    }

    public String show() {
        return "Number: " + num + ", String: " + str;
    }

    @Override
    public void lock() {
        return;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
