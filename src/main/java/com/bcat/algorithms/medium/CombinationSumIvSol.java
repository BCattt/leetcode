package com.bcat.algorithms.medium;

import java.util.Arrays;

public class CombinationSumIvSol {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIvSol sol = new CombinationSumIvSol();
        int[] nums;
        int target;

        nums = new int[]{1,2,3};
        target = 4;
        System.out.println(Arrays.toString(nums) + ", target = " + target + ": " + sol.combinationSum4(nums, target));

        nums = new int[]{9};
        target = 3;
        System.out.println(Arrays.toString(nums) + ", target = " + target + ": " + sol.combinationSum4(nums, target));

        nums = new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        // 3 + 7
        // 3 + 4 + 3
        // 3 + 3 + 4
        // 4 + 6
        // 4 + 3 + 3
        // 5 + 5
        // 6 + 4
        // 7 + 3
        // 10
        target = 10;
        System.out.println(Arrays.toString(nums) + ", target = " + target + ": " + sol.combinationSum4(nums, target));

        // 10
        nums = new int[]{1,2};
        target = 10;
        System.out.println(Arrays.toString(nums) + ", target = " + target + ": " + sol.combinationSum4(nums, target));
    }
}
