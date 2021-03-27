package com.bcat.algorithms.easy;

public class MaxConsecutiveOnesSol {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int consecutiveOnes = 0;
        for (int i = 0; i < nums.length;) {
            while (i < nums.length && nums[i++] == 1) {
                ++consecutiveOnes;
            }
            if (consecutiveOnes > max) {
                max = consecutiveOnes;
            }
            consecutiveOnes = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesSol sol = new MaxConsecutiveOnesSol();
        System.out.println(sol.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println(sol.findMaxConsecutiveOnes(new int[]{1}));
        System.out.println(sol.findMaxConsecutiveOnes(new int[]{0}));
        System.out.println(sol.findMaxConsecutiveOnes(new int[]{}));

    }
}
