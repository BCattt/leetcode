package com.bcat.algorithms.easy;

/**
 * Solution for leetcode 896 Monotonic Array.
 */
public class MonotonicArraySol {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) {
            return true;
        }
        int dir = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            int diff = A[i + 1] - A[i];
            if (diff != 0 && dir == 0) {
                dir = diff;
            }
            if (diff * dir < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MonotonicArraySol sol = new MonotonicArraySol();
        System.out.println(sol.isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(sol.isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(sol.isMonotonic(new int[]{1, 3, 2}));
        System.out.println(sol.isMonotonic(new int[]{1, 2, 4, 5}));
        System.out.println(sol.isMonotonic(new int[]{1, 1, 1}));
        System.out.println(sol.isMonotonic(new int[]{1, 1, 0}));
        System.out.println(sol.isMonotonic(new int[]{2, 2, 2, 1, 4, 5}));
    }
}
