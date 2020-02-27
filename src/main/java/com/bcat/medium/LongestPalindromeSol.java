package com.bcat.medium;

/**
 * Problem #2 Medium Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * <b>Example 1:</b>
 * {@code
 *   Input: "babad"
 *   Output: "bab"
 *   Note: "aba" is also a valid answer.
 * }
 * <b>Example 2:</b>
 * {@code
 *   Input: "cbbd"
 *   Output: "bb"
 * }
 *
 */
public class LongestPalindromeSol {
    public static String longestPalindrome(String s) {
        char[] sArray = s.toCharArray();
        int startPos = 0, endPos = 0, curPos = 0;
        // 最长子串, 最长子串开始位置
        int maxLen = 0, maxStart = 0;
        // 当前最长子串长度
        int curLen = 0;
        while (curPos < sArray.length) {
            curLen = 1;
            startPos = endPos = curPos;
            // 左边相同子串
            while (--startPos >= 0 && sArray[startPos] == sArray[curPos]) {
                ++curLen;
            }
            // 右边相同子串
            while (++endPos < sArray.length && sArray[endPos] == sArray[curPos]) {
                ++curLen;
            }
            while (startPos >= 0 && endPos < sArray.length) {
                if (sArray[startPos] == sArray[endPos]) {
                    curLen += 2;
                } else {
                    break;
                }
                --startPos;
                ++endPos;
            }
            if (curLen > maxLen) {
                maxStart = startPos + 1;
                maxLen = curLen;
            }
            ++curPos;
        }
        return s.substring(maxStart, maxLen + maxStart);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));

        s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
