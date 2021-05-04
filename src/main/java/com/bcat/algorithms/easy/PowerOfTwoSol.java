package com.bcat.algorithms.easy;

/**
 * Solution for leetcode 231 - Power of Tow.
 */
public class PowerOfTwoSol {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1 || n == 2) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        PowerOfTwoSol sol = new PowerOfTwoSol();
        int n;

        n = 1;
        System.out.println(n + ": " + sol.isPowerOfTwo(n));

        n = 2;
        System.out.println(n + ": " + sol.isPowerOfTwo(n));

        n = 3;
        System.out.println(n + ": " + sol.isPowerOfTwo(n));

        n = 4;
        System.out.println(n + ": " + sol.isPowerOfTwo(n));

        n = 5;
        System.out.println(n + ": " + sol.isPowerOfTwo(n));

        n = 6;
        System.out.println(n + ": " + sol.isPowerOfTwo(n));

        n = 7;
        System.out.println(n + ": " + sol.isPowerOfTwo(n));

        n = 8;
        System.out.println(n + ": " + sol.isPowerOfTwo(n));

        n = 9;
        System.out.println(n + ": " + sol.isPowerOfTwo(n));

        n = 16;
        System.out.println(n + ": " + sol.isPowerOfTwo(n));
    }
}
