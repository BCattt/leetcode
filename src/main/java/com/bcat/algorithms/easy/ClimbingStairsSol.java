package com.bcat.algorithms.easy;

/**
 * Solution for Leetcode Algorithms-70 Climbing Stairs.
 * <p>
 * You are climbing a stair case. It takes {@code n} steps to reach to the top.
 * Each time you can either climb {@code 1} or {@code 2} steps. In how many
 * distinct ways can you climb to the top ?
 * </p>
 * <p>
 * <b>Note: </b> Given {@code n} will be a positive integer.
 * </p>
 * <p><b>Example 1:</b>
 * <pre>
 * <b>Input: </b> 2
 * <b>Output: </b> 2
 * <b>Explanation: </b>There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * </pre>
 * </p>
 * <p><b>Example 2:</b>
 *  <pre>
 *  <b>Input: </b> 3
 *  <b>Output: </b> 3
 *  <b>Explanation: </b>There are three ways to climb to the top.
 *  1. 1 step + 1 step + 1 step
 *  2. 1 step + 2 steps
 *  3. 2 steps + 1 step
 *  </pre>
 *  </p>
 *  <p>
 *  <b>Solution: </b>
 *  <pre>
 *
 *
 *  </pre>
 *  </p>
 */
public class ClimbingStairsSol {
    public static int climbStairs(int n) {
        int result = 0;
        // 从n个1, 0个2开始计算
        int c1 = n, c2 = 0;
        while (n >= 2 * c2) {
            if (c1 == 0 || c2 == 0) {
                result += 1;
            } else if (c1 < c2) {
                result += (c2 + 1) * c1;
            } else if (c1 > c2) {
                result += (c1 + 1) * c2;
            } else {
                result += (c1 + 1) * c2;
            }
            c1 -= 2;
            ++c2;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(n + " = " + climbStairs(n));
        n = 2;
        System.out.println(n + " = " + climbStairs(n));
        n = 3;
        System.out.println(n + " = " + climbStairs(n));
        n = 4;
        System.out.println(n + " = " + climbStairs(n));
        n = 5;
        System.out.println(n + " = " + climbStairs(n));
        n = 6;
        System.out.println(n + " = " + climbStairs(n));
        n = 7;
        System.out.println(n + " = " + climbStairs(n));
    }
}
