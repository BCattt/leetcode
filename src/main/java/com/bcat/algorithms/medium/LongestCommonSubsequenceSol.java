package com.bcat.algorithms.medium;

/**
 * Solution for leetcode 1143 - Longest Common Subsequence.
 */
public class LongestCommonSubsequenceSol {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        char[] tA1 = text1.toCharArray();
        char[] tA2 = text2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        int max = 0;

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (tA1[i - 1] == tA2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]  + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestCommonSubsequenceSol sol = new LongestCommonSubsequenceSol();
        System.out.println(sol.longestCommonSubsequence("abcde", "ace"));
        System.out.println(sol.longestCommonSubsequence("abc", "abc"));
        System.out.println(sol.longestCommonSubsequence("abc", "def"));

    }
}
