package com.bcat.algorithms.medium;

/**
 * Solution for leetcode 421 - Maximum Xor of Two Numbers in an Array.
 */
public class MaximumXorOfTowNumbersInAnArraySol {
    public int findMaximumXor(int[] nums) {
        int max = 0;
        int sz = nums.length;
        for (int i = 0; i < sz; ++i) {
            for (int j = i + 1; j < sz; ++j) {
                int xor = nums[i] ^ nums[j];
                if (xor > max) {
                    max = xor;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumXorOfTowNumbersInAnArraySol sol = new MaximumXorOfTowNumbersInAnArraySol();
        int[] nums;

        nums = new int[]{3,10,5,25,2,8};
        System.out.println(sol.findMaximumXor(nums));

        nums = new int[]{0};
        System.out.println(sol.findMaximumXor(nums));

        nums = new int[]{2,4};
        System.out.println(sol.findMaximumXor(nums));

        nums = new int[]{8,10,2};
        System.out.println(sol.findMaximumXor(nums));

        nums = new int[]{14,70,53,83,49,91,36,80,92,51,66,70};
        System.out.println(sol.findMaximumXor(nums));
    }
}
