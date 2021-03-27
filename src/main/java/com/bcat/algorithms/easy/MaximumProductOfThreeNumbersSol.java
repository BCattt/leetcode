package com.bcat.algorithms.easy;

import java.util.Arrays;

/**
 * Solution for Leetcode - 628 Maximum Product of Three Numbers.
 */
public class MaximumProductOfThreeNumbersSol {
    public int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);

        int positiveCount = 0;
        for (int i = nums.length - 1; i >= nums.length - 3; --i) {
            if (nums[i] > 0) {
                positiveCount++;
            }
        }
        if (positiveCount == 3) {
            // 3个正数, 看最小的2个负数与2个次小正数乘积决定
            return nums[nums.length - 1] * Math.max(nums[0] * nums[1], nums[nums.length - 2] * nums[nums.length - 3]);
        } else if (positiveCount == 0) {
            // 0个正数, 取最大的3个数相乘
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        } else {
            // 2个或1个正数, 取最大正数*最小的2个负数
            return nums[0] * nums[1] * nums[nums.length - 1];
        }
    }

    public static void main(String[] args) {
        MaximumProductOfThreeNumbersSol sol = new MaximumProductOfThreeNumbersSol();
        System.out.println(sol.maximumProduct(new int[]{1, 2, 3}));
        System.out.println(sol.maximumProduct(new int[]{1, 2, 3, 4}));
        System.out.println(sol.maximumProduct(new int[]{1, 0, 3, 4}));
        System.out.println(sol.maximumProduct(new int[]{1, 0, 3, 4, -1}));
        System.out.println(sol.maximumProduct(new int[]{-1, 0, 2, -1}));
        System.out.println(sol.maximumProduct(new int[]{-1, 0, -2, -1}));
        System.out.println(sol.maximumProduct(new int[]{-1, -2, -3}));
        System.out.println(sol.maximumProduct(new int[]{-1, -2, -3, -4}));
        System.out.println(sol.maximumProduct(new int[]{-1, -2, -3, -4, 5}));
        System.out.println(sol.maximumProduct(new int[]{-1, -2, -3, -4, 5, 6}));
        System.out.println(sol.maximumProduct(new int[]{-1, -2, -3, -4, 0, -5}));
        System.out.println(sol.maximumProduct(new int[]{-1, -2, -3, -4, 0, -5, 6}));
        System.out.println(sol.maximumProduct(new int[]{-100, -98, -1, 2, 3, 4}));
    }
}
