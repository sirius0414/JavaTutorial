package org.siyue.javatutorial.concurrent;

import java.util.concurrent.*;

public class RunnableCallableDemo {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 1. Runnable 示例（无返回值）
        Runnable runnableTask = () -> {
            System.out.println("Runnable 执行线程：" + Thread.currentThread().getName());
        };
        executor.execute(runnableTask);

        // 2. Callable 示例（有返回值）
        Callable<String> callableTask = () -> {
            System.out.println("Callable 执行线程：" + Thread.currentThread().getName());
            return "Callable 的返回值";
        };
        Future<String> future = executor.submit(callableTask);

        // 获取返回结果
        String result = future.get();
        System.out.println("Callable 返回结果：" + result);

        executor.shutdown();
    }
}
