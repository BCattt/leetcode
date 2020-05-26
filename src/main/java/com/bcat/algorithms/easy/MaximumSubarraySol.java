package com.bcat.algorithms.easy;

/**
 * Solution for LeetCode 53-Maximum Subarray.
 *
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least
 * one number) which has the largest sum and return its sum.
 * </p>
 * <p><b>Example: </b><pre>
 *   <b>Input: </b>[-2,1,-3,4,-1,2,1,-5,4],
 *   <b>Output: </b>6
 *   <b>Explanation: </b>[4,-1,2,1] has the largest sum = 6.
 * </pre>
 * </p>
 * <p><b>Follow up: </b><pre>
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * </pre>
 * </p>
 * <p><b>Solution: </b><pre>
 *     1. 动态规划
 *     Si表示第i个数的最大子序列和, Ni表示第i个数字, 下标从0开始.那么Si的状态转移方程如下:
 *     i = 0, S0 = N0, 只有一个数, 最大和为自身
 *     i = 1, S1 = max(S0 + N1, N1), 有2个数, 则最大和为自身或加上自身
 *     i = 2, S2 = max(S1 + N2, N2), 有3个数, 则最大和为自身或n-1的最大和加上自身
 *     ...
 *     i = n, Sn = max(Sn-1 + Nn, Nn), 有n个数, 则最大和为自身或n-1的最大和加上自身
 *     优化:
 *     由于Sn只与上一个数的和有关, 因此可以只使用一个变量, 而不用数组.
 * </pre>
 * <p><b>2. 分治</b></p>
 * </p>
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class MaximumSubarraySol {
    /**
     * 解法1 使用状态数组记录每个数的状态.
     */
    public static int maxSubarray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int curMax = dp[0];
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > curMax) {
                curMax = dp[i];
            }
        }
        return curMax;
    }

    /**
     * 解法2: 只使用一个变量
     */
    public static int maxSubarray2(int[] nums) {
        int preMaxSum = nums[0];
        int curMaxSum = preMaxSum;
        for (int i = 1; i < nums.length; ++i) {
            preMaxSum = Math.max(preMaxSum + nums[i], nums[i]);
            if (preMaxSum > curMaxSum) {
               curMaxSum = preMaxSum;
            }
        }
        return curMaxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarray(new int[]{-2,-1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubarray2(new int[]{-2,-1,-3,4,-1,2,1,-5,4}));
    }
}
