package com.bcat.interview.lcci.easy;

/**
 * Solution for LeetCode problem 01.06-LCCI-Compress String.
 * <p>Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string {@literal aabcccccaaa} would
 * become {@literal a2blc5a3}. If the "compressed" string would not become smaller
 * than the original string, your method should return the original string.
 * You can assume the string has only uppercase and lowercase letters (a - z).
 *</p>
 *<p>
 *<p><b>Example 1:</b>
 * {@literal
 *   Input: "aabcccccaaa"
 *   Output: "a2b1c5a3"
 * }
 *</p>
 *<p><b>Example 2:</b></p>
 * {@literal
 * Input: "abbccd"
 * Output: "abbccd"
 * Explanation:
 * The compressed string is "a1b2c2d1", which is longer than the original string.
 * }
 *</p>
 * <p><b>Note:</b>
 * <ol>
 *     <li>{@literal 0 <= S.length <= 50000}</li>
 * </ol>
 * </p>
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class CompressStringSol {
    public static String compressString(String S) {
        StringBuilder strBuilder = new StringBuilder();
        char ch = '\0';
        int count = 0;
        for (char c : S.toCharArray()) {
            if (ch == c) {
                ++count;
            } else {
                strBuilder.append(count);
                count = 1;
                strBuilder.append(c);
                ch = c;
            }
        }
        strBuilder.append(count);
        return strBuilder.length() - 1 >= S.length() ? S : strBuilder.deleteCharAt(0).toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString(""));
        System.out.println(compressString("a"));
        System.out.println(compressString("bb"));
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("abbccd"));
    }

}
