package com.bcat.algorithms.easy;

/**
 * Solution for LeetCode algorithms 198 - House Robber.
 *
 * <p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping
 * you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each
 * house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * </p>
 * <p>
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * </p>
 * <p><pre>
 * <b>Example 2:</b>
 *
 * <b>Input:</b> [2,7,9,3,1]
 * <b>Output:</b> 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 * </pre>
 * </p>
 *
 * <p><b>Solution: </b>
 * <p>1. 动态规划
 * <pre>
 *     假设f(k)表示从前k个房屋中能偷窥到的最大金额, Ai = 第i个房屋的金额.
 *     状态转移方程:
 *     1. n = 1, f(1) = A1
 *     2. n = 2, f(2) = max(A1, A2)
 *     3. n = 3, 有两个选项:
 *        3.1 偷窥第三个房子, 将金额与第一个房子相加: f(1) + f(3)
 *        3.2 不偷窥第三个房子, 保持现有最大金额: f(2)
 *        即: f(k) = max(f(k-2) + Ak, f(k-1))
 *     设f(-1) = f(0) = 0, 来简化代码.
 *     按照动态规划, 可以用一个数组来存储并计算结果. 由于要计算f(k-2)的值, 所以状态数组
 *     比原数组长度+2, 而dp[0]和dp[1]分别存放0, 表示初始状态, 真正的偷窥从dp[2]开始.
 *     <b>优化: </b>
 *     而由于f(k)只与f(k-2)和f(k-1)这两个值相关, 因此, 可以只用两个变量保存即可.
 * </pre>
 * </p>
 * </p>
 */
public class HouseRobberSol {
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        int max = 0;
        // 下标从2开始
        for (int i = 0, j = i + 2; i < nums.length; ++i, ++j) {
            dp[j] = Math.max(dp[j - 2] + nums[i], dp[j - 1]);
            if (dp[j] > max) {
                max = dp[j];
            }
        }
        return max;
    }

    public static int rob2(int[] nums) {
        // f(k - 2)
        int preMax = 0;
        // f(k - 1)
        int max = 0;
        for (int m : nums) {
            // 先保存当前最大值
            int tmp = max;
            // 计算f(k)
            max = Math.max(preMax + m, max);
            // 准备判断下一个房屋
            preMax = tmp;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));

        System.out.println(rob2(new int[]{2, 3, 2}));
        System.out.println(rob2(new int[]{1, 2, 3, 1}));
        System.out.println(rob2(new int[]{2, 7, 9, 3, 1}));
    }

}
