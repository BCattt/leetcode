package com.bcat.algorithms.medium;

import java.math.BigInteger;

/**
 * Solution for LeetCode algorithm problem 365-Water and Jug problem.
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class WaterAndJugProblemSol {
    public static boolean canMeasureWather(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == 0 || y == 0) return z == 0 || x + y == z;
        return z % BigInteger.valueOf(x).gcd(BigInteger.valueOf(y)).intValue() == 0;
    }
}
