package com.bcat.algorithms.medium;

/**
 * Solution for leetcode 面试题 16.01 - Swap Numbers LCCI.
 */
public class SwapNumbersLcciSol {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] ^= numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }


}
