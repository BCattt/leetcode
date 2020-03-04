package com.bcat.algorithms.easy;

/**
 * Solution for Leetcode problem 9.Palindrome Number
 */
public class PalindromeNumber {
    public boolean isPalindromNumber(int x) {
        // 负数不是回文数字
        if (x < 0)
            return false;
        int reverse = 0;
        int src = x;
        while (src != 0) {
            reverse = reverse * 10 + src % 10;
            src /= 10;
        }
        return (x ^ reverse) == 0;
    }
}
