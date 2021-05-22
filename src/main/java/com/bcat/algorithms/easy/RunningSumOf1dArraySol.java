package com.bcat.algorithms.easy;

/**
 * Solution for leetcode 1480 - Running Sum of 1d Array.
 */
public class RunningSumOf1dArraySol {
    public int[] runningSum(int[] nums) {
        int sz = nums.length;
        int[] result = new int[sz];
        result[0] = nums[0];
        for (int i = 1; i < sz; ++i) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }
}
