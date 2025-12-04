package org.siyue.utils;

public class Combination {
    public static long combination(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        if (k > n - k) {
            k = n - k; // use symmetry
        }
        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - k + i) / i;
        }
        return result;
    }
}
