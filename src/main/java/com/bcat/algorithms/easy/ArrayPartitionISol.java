package com.bcat.algorithms.easy;

import java.util.Arrays;

public class ArrayPartitionISol {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            maxSum += nums[i];
        }
        return maxSum;
    }

    public static void main(String[] args) {
        ArrayPartitionISol sol = new ArrayPartitionISol();
        System.out.println(sol.arrayPairSum(new int[]{1, 4, 3, 2}));
        System.out.println(sol.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
    }
}
