package com.bcat.algorithms.easy;

import java.util.Arrays;

/**
 * Solution for leetcode 167 - Tow Sum II - Input arrayy is sorted.
 */
public class TwoSum2InputArrayIsSortedSol {
    public int[] twoSum(int[] numbers, int target) {
        int idx1 = 0;
        int idx2 = 0;
        int n = numbers.length;
        while (idx1 < n) {
            int sub = target - numbers[idx1];
            if ((idx2 = Arrays.binarySearch(numbers, idx1 + 1, n, sub)) > 0) {
                return new int[]{idx1 + 1, idx2 + 1};
            }
            ++idx1;
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum2InputArrayIsSortedSol sol = new TwoSum2InputArrayIsSortedSol();
        int[] numbers;
        int target;

        numbers = new int[]{2,7,11,15};
        target = 9;
        System.out.println(Arrays.toString(sol.twoSum(numbers, target)));

        numbers = new int[]{2,3,4};
        target = 6;
        System.out.println(Arrays.toString(sol.twoSum(numbers, target)));

        numbers = new int[]{-1, 0};
        target = -1;
        System.out.println(Arrays.toString(sol.twoSum(numbers, target)));
    }
}
