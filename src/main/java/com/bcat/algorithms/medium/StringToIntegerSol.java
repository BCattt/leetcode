package com.bcat.algorithms.medium;

/**
 * Solution for LeetCode problem 8.String to Integer (atoi)
 *
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 */
public class StringToIntegerSol {
    public static int myAtoi(String str) {
        // 去除开头的空格
        byte[] bytes = str.getBytes();
        int digitStartPos = 0;
        while (digitStartPos < bytes.length && ' ' == bytes[digitStartPos]) {
            ++digitStartPos;
        }
        int sign = 1;
        long result = 0;
        if (digitStartPos < bytes.length && '-' == bytes[digitStartPos]) {
            sign = -1;
            ++digitStartPos;
        } else if (digitStartPos < bytes.length && '+' == bytes[digitStartPos]) {
            ++digitStartPos;
        }
        // 去除开头的0
        while (digitStartPos < bytes.length && '0' == bytes[digitStartPos]) {
            ++digitStartPos;
        }
        // 开始转换
        while (digitStartPos < bytes.length && '0' <= bytes[digitStartPos] && '9' >= bytes[digitStartPos]) {
            result = result * 10 + (bytes[digitStartPos] - '0');
            ++digitStartPos;
            if (result > Integer.MAX_VALUE ) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return (int)result * sign;

    }

    public static void main(String[] args) {
        System.out.println("myAtoi() = " + myAtoi(""));
        System.out.println("myAtoi(   ) = " + myAtoi("  "));
        System.out.println("myAtoi(42) = " + myAtoi("42"));
        System.out.println("myAtoi(    -42) = " + myAtoi("    -42"));
        System.out.println("myAtoi(4193 with words) = " + myAtoi("4193 with words"));
        System.out.println("myAtoi(words and 987) = " + myAtoi("words and 987"));
        System.out.println("myAtoi(-91283472332) = " + myAtoi("-91283472332"));
        System.out.println("myAtoi(91283472332) = " + myAtoi("91283472332"));
        System.out.println("myAtoi(9223372036854775808) = " + myAtoi("9223372036854775808"));
    }
}

