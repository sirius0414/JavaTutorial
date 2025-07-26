package org.siyue.javatutorial;

public class TempTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts");
        Thread.currentThread().join(); // 自己等自己
        System.out.println("This line will never be printed");
    }
}
