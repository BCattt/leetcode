package com.bcat.algorithms.easy;

/**
 * Solution for LeetCode Algorithm problem 1071-Greatest Common Divisor of Strings.
 *
 * <p>For strings {@code S} and {@code T}, we say "{@code T} divides {@code S}"
 * if and only if {@code S = T + ... + T}  ({@code T} concatenated with itself 1 or more times)
 * Return the largest string {@code X} such that {@code X} divides {@code str1} 
 * and {@code X} divides {@code str2}.
 * <p>Example 1:
 * {@code
 *   Input: str1 = "ABCABC", str2 = "ABC"
 *   Output: "ABC"
 * }
 * <p>Example 2:
 * {@code
 *   Input: str1 = "ABABAB", str2 = "ABAB"
 *   Output: "AB"
 * }
 * <p>Example 3:
 * {@code
 *   Input: str1 = "LEET", str2 = "CODE"
 *   Output: ""
 * }
 * <p>Note:
 * <ul>
 *     <li>{@code 1 <= str1.length <= 1000}</li>
 *     <li>{@code 1 <= str2.length <= 1000}</li>
 *     <li>{@code str1[i]} and {@code str2[i]} are English uppercase letters</li>
 * </ul>
 *
 * <p><b>解题思路:</b>
 * 最大公因子应保持公因子尽量长, 因此同时遍历两个字符串, 先找出最大的共同子串, 然后在下一个
 * 不同字符处开始回溯, 每减去一个字符查看是否是字符串的因子, 直到公共子串长度变成0或找到
 * 最大公共因子.
 *
 * <p>算法2是对算法1的性能优化, 不再使用Java对象, 而直接使用原始类型char和char数组.
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class GreatestCommonDivisorOfStringsSol {
    public static String gcdOfStrings(String str1, String str2) {
        StringBuilder commonDivisor = new StringBuilder();
        // find the greatest common substring
        for (int i = 0, j = 0; i < str1.length() && j < str2.length(); ++i, ++j) {
            if (str1.charAt(i) == str2.charAt(j)) {
                commonDivisor.append(str1.charAt(i));
            }
        }
        //  Test the greatest common substring
        boolean greatestCommonDivisor = false;
        while (commonDivisor.length() > 0) {
            greatestCommonDivisor = true;
            for (int i = commonDivisor.length(); i < str1.length(); i += commonDivisor.length()) {
                if (!str1.startsWith(commonDivisor.toString(), i)) {
                    greatestCommonDivisor = false;
                    // delete the last character and continue the test for str2
                    commonDivisor.deleteCharAt(commonDivisor.length() - 1);
                    break;
                }
            }
            for (int j = commonDivisor.length(); j < str2.length() && commonDivisor.length() > 0; j += commonDivisor.length()) {
                if (!str2.startsWith(commonDivisor.toString(), j)) {
                    greatestCommonDivisor = false;
                    // delete the last character and continue the test for str2
                    commonDivisor.deleteCharAt(commonDivisor.length() - 1);
                    break;
                }
            }
            if (greatestCommonDivisor) {
                break;
            }
        }
        return commonDivisor.toString();
    }

    public static String gcdOfStrings2(String str1, String str2) {
        char[] str1Char = str1.toCharArray();
        char[] str2Char = str2.toCharArray();
        int commonDivisorIdx = 0;
        for (int i = 0, j = 0; i < str1Char.length && j < str2Char.length; ++i, ++j) {
            if (str1Char[i] == str2Char[j]) {
                commonDivisorIdx = i;
            }
        }
        boolean greatestCommonDivisor;
        while (commonDivisorIdx >= 0) {
            greatestCommonDivisor = true;
            if (!isDivisor(str1Char, commonDivisorIdx)) {
                greatestCommonDivisor = false;
                --commonDivisorIdx;
            }
            if (commonDivisorIdx < 0) {
                break;
            }
            if (!isDivisor(str2Char, commonDivisorIdx)) {
                greatestCommonDivisor = false;
                --commonDivisorIdx;
            }
            if (greatestCommonDivisor) {
                break;
            }
        }
        return commonDivisorIdx >= 0 ? str1.substring(0, commonDivisorIdx + 1) : "";
    }

    public static boolean isDivisor(char[] strCharArray, int divisorIdx) {
        for (int i = divisorIdx + 1; i < strCharArray.length; i += divisorIdx + 1) {
            int endIdx = 0;
            for (int idx = i; idx < strCharArray.length && endIdx <= divisorIdx; ++idx, ++endIdx) {
                if (strCharArray[idx] != strCharArray[endIdx]) {
                    return false;
                }
            }
            // 只有部分与子串相同
            if (endIdx > 0 && endIdx != divisorIdx + 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("LEET", "CODE"));
        System.out.println(gcdOfStrings("ABCDEF", "ABC"));
        long end = System.nanoTime();
        System.out.println("Time elapsed = " + (end - start) / 1_000 + "us");
        start = System.nanoTime();
        System.out.println(gcdOfStrings2("ABCABC", "ABC"));
        System.out.println(gcdOfStrings2("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings2("LEET", "CODE"));
        System.out.println(gcdOfStrings2("ABCDEF", "ABC"));
        end = System.nanoTime();
        System.out.println("Time elapsed = " + (end - start) / 1_000 + "us");
    }
}
