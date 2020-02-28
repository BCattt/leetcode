package com.bcat.easy;

/**
 * Solution for LeetCode question 7-Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * <p>
 *     思路很简单，依次得到整数的每个数字，反向生成一个整数即可
 * </p>
 */
public class ReverseIntegerSol {
    public static int reverse(int x) {
        // 将负整数统一成正整数处理
        int sign = x > 0 ? 1 : -1;
        int srcInt = Math.abs(x);
        // 使用长整形来保存结果，避免32位整数溢出
        long result = 0;

        // 按相反位置计算结果
        while (srcInt != 0) {
            result = result * 10 + srcInt % 10;
            srcInt /= 10;
        }
        result *= sign;
        if (result <= Integer.MIN_VALUE || result >= Integer.MAX_VALUE) {
            return 0;
        }
        return (int)result;
    }
}
