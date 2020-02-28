package com.bcat.easy;

/**
 * Solution for LeetCode problem 14.Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 *
 * 从第一个字符串的第一个字母开始遍历，如果所有字符串遍历完成，则增加一个字符，继续遍历。
 * 时间复杂度O(n), 空间复杂度O(1).
 *
 */
public class LongestCommonPrefixSol {
    public static String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs.length == 1 ? strs[0] : "";
        while (strs.length > 1) {
            if (commonPrefix.length() < strs[0].length()) {
                commonPrefix = strs[0].substring(0, commonPrefix.length() + 1);
            } else {
                break;
            }
            for (String str : strs) {
                if (!str.startsWith(commonPrefix)) {
                    if (commonPrefix.length() > 0) {
                        return commonPrefix.substring(0, commonPrefix.length() - 1);
                    } else {
                        return commonPrefix;
                    }
                } else if (commonPrefix.length() == 0) {
                    return commonPrefix;
                }
            }
        }
        return commonPrefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{""}));
        System.out.println(longestCommonPrefix(new String[]{"", "a"}));
        System.out.println(longestCommonPrefix(new String[]{"a"}));
        System.out.println(longestCommonPrefix(new String[]{"ab"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "ab"}));
        System.out.println(longestCommonPrefix(new String[]{"c", "cb"}));
        System.out.println(longestCommonPrefix(new String[]{"cb", "c"}));
    }
}

