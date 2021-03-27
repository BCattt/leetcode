package com.bcat.algorithms.easy;

public class NonDecreasingArraySol {
    public boolean checkPossibility(int[] nums) {
        int decreasing = 0;
        int decreasingIdx = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                decreasingIdx = i;
                ++ decreasing;
            }
        }
        if (decreasing > 1) {
            return false;
        }
        for (int s = decreasingIdx - 1, e = decreasingIdx + 1; s >= 0 && e <= nums.length - 1; --s, ++e) {
            if (nums[s] > nums[e]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NonDecreasingArraySol sol = new NonDecreasingArraySol();
        System.out.println(sol.checkPossibility(new int[]{4, 2, 3}));
        System.out.println(sol.checkPossibility(new int[]{4, 2, 1}));
        System.out.println(sol.checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println(sol.checkPossibility(new int[]{5, 7, 1, 8}));
        System.out.println(sol.checkPossibility(new int[]{1, 2, 5, 2, 2}));
        System.out.println(sol.checkPossibility(new int[]{1, 2, 5, 3, 2}));
        System.out.println(sol.checkPossibility(new int[]{1, 2, 5, 2, 3}));
    }
}
