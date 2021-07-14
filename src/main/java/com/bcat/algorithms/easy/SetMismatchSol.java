package com.bcat.algorithms.easy;

import java.util.Arrays;

public class SetMismatchSol {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] appear = new int[n + 1];
        for (int num : nums) {
            appear[num]++;
        }
        int nonAppear = 0;
        int repeated = 0;
        for (int i = 1; i <= n; ++i) {
            if (appear[i] == 0) {
                nonAppear = i;
            } else if (appear[i] > 1) {
                repeated = i;
            }
        }
        return new int[]{repeated, nonAppear};
    }

    public static void main(String[] args) {
        SetMismatchSol sol = new SetMismatchSol();
        System.out.println(Arrays.toString(sol.findErrorNums(new int[]{1,2,2,4})));
        System.out.println(Arrays.toString(sol.findErrorNums(new int[]{1,3,3,4})));
        System.out.println(Arrays.toString(sol.findErrorNums(new int[]{1,2,3,3})));
        System.out.println(Arrays.toString(sol.findErrorNums(new int[]{1,2,4,4})));
        System.out.println(Arrays.toString(sol.findErrorNums(new int[]{4,2,1,4})));
        System.out.println(Arrays.toString(sol.findErrorNums(new int[]{1,1})));
        System.out.println(Arrays.toString(sol.findErrorNums(new int[]{2,2})));
        System.out.println(Arrays.toString(sol.findErrorNums(new int[]{3,2,3,4,5})));
    }
}
