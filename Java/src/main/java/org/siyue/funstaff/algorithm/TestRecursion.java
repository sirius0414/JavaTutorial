package org.siyue.funstaff.algorithm;

import java.util.List;

public class TestRecursion {
    public static void main(String[] args) {
        f(3);
    }

    static void f(int n) {
        if (n == 0) return;

        f(n - 1);
        System.out.print(n + " ");
        f(n - 1);
    }
}
