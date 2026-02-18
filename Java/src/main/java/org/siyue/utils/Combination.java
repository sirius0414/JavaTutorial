package org.siyue.utils;

import java.util.ArrayList;
import java.util.List;

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

    // 从List中选K个，返回所有可能的选择
    public static <T> List<List<T>> combine(List<T> list, int k) {
        List<List<T>> res = new ArrayList<>();
        backtrack(list, k, 0, new ArrayList<>(), res);
        return res;
    }

    private static <T> void backtrack(
            List<T> list,
            int k,
            int start,
            List<T> path,
            List<List<T>> res
    ) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            path.add(list.get(i));
            backtrack(list, k, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

}
