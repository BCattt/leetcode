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
 *  <p>1. 动态规划<pre>
 *  假设f(n)为n个台阶的上法, 到达n台阶时, 即可以从n-1只上一步, 也可以从n-2上两步, 这是两种
 *  单独的上法, 因此, f(n) = f(n-1) + f(n-2). 我们设f(0) = 1, 简化计算
 *  那么其状态转移方程如下:
 *  f(0) = 1
 *  f(1) = 1,
 *  f(2) = 2,
 *  f(3) = 3,
 *  f(4) = 5
 *  ...
 *  f(n) = f(n-1) + f(n-2)
 *  实际是这就是斐波那契数.
 *  我们还发现, f(n)只与f(n-1)和f(n-2)有关, 因此可以简化状态表为2个变量.
 *  </pre>
 *  </p>
 *  </p>
 *
 *  @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class ClimbingStairsSol {
    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        // 状态转移表
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStairs2(int n) {
        if (n <= 1) {
            return 1;
        }
        // 简化状态转移表, 只记录上一个及上二个数
        int prevStep = 1, prevPrevStep = 1;
        int curStep = 0;
        for (int i = 2; i <= n; ++i) {
            curStep = prevStep + prevPrevStep;
            prevPrevStep = prevStep;
            prevStep = curStep;
        }
        return curStep;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(n + " = " + climbStairs(n));
        System.out.println(n + " = " + climbStairs2(n));
        n = 2;
        System.out.println(n + " = " + climbStairs(n));
        System.out.println(n + " = " + climbStairs2(n));
        n = 3;
        System.out.println(n + " = " + climbStairs(n));
        System.out.println(n + " = " + climbStairs2(n));
        n = 4;
        System.out.println(n + " = " + climbStairs(n));
        System.out.println(n + " = " + climbStairs2(n));
        n = 5;
        System.out.println(n + " = " + climbStairs(n));
        System.out.println(n + " = " + climbStairs2(n));
        n = 6;
        System.out.println(n + " = " + climbStairs(n));
        System.out.println(n + " = " + climbStairs2(n));
        n = 7;
        System.out.println(n + " = " + climbStairs(n));
        System.out.println(n + " = " + climbStairs2(n));
    }
}
