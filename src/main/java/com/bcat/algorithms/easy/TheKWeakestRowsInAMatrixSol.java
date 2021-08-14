package com.bcat.algorithms.easy;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrixSol {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>((e1, e2) -> {
                    if (e1.getKey() == e2.getKey()) {
                        return e1.getValue() - e2.getValue();
                    }
                    return e1.getKey() - e2.getKey();
                });
        for (int row = 0; row < rows; ++row) {
            int weakness = 0;
            for (int num : mat[row]) {
                if (num == 1) {
                    ++weakness;
                } else {
                    break;
                }
            }
            queue.add(new AbstractMap.SimpleEntry<>(weakness, row));
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = queue.poll().getValue();
        }
        return ans;
    }
}
