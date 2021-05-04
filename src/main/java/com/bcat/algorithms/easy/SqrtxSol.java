package com.bcat.algorithms.easy;

/**
 * Solution for leetcode 69 - Sqrt(x).
 */
public class SqrtxSol {
    public int mySqrt(int x) {
        return ((int )Math.sqrt(x)) * 10 / 10;
    }

    public static void main(String[] args) {
        SqrtxSol sol = new SqrtxSol();

        int x;

        x = 4;
        System.out.println(x + ": " + sol.mySqrt(x));

        x = 8;
        System.out.println(x + ": " + sol.mySqrt(x));

        x = 7;
        System.out.println(x + ": " + sol.mySqrt(x));

        x = 10;
        System.out.println(x + ": " + sol.mySqrt(x));
    }
}
