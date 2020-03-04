package com.bcat.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Solution for LeetCode Problem 17.Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * 1 - ''
 * 2 - 'abc'
 * 3 - 'def'
 * 4 - 'ghi'
 * 5 - 'jkl'
 * 6 - 'mno'
 * 7 - 'pqrs'
 * 8 - 'tuv'
 * 9 - 'wxyz'
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <b>Note:</b>
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * 解题思路：
 * 假设有n个数字
 * 1. 暴力求解法
 *    组合的个数为每个数字对应的字母数的乘积，
 * 2. 递归
 *    只有1个数字时组合为这个数字对应的字母
 *    有2个数字时，将第2个数字的每个字母作为前缀即可
 *    ...
 *    以此类推，对于n个数字，就是将第n个数字对应的字母添加到n-1所有组合前面
 *    递归深度为n
 * 3. 转换为填字母
 *    这是一个求组合的问题，对于给定的数字组合，其所有组合数是确定的，每个组合的长度也是确定的，因此，可以计算每个位置的字母，然后直接
 *    填充字母即可：
 *    组合数为每个数字n对应字母数cn相乘的结果R
 *    那么，我们以一定顺序，每次只变化最后一个数字的字母，就有了一个顺序
 *    对于第n(从0开始)个数字，第k(从0开始)个字母，其出现的次数为R / cn，相应地，其出现的位置为  R / cn + k
 *    可以把所有组合看成一个字母的二维数组，列数固定为数字的个数，每一行对应一个组合
 *
 * @author <a href="zjebusiness@gmail.com">赵峻</a>
 */
public class LetterCombinationsOfaPhoneNumberSol {
    static final String[] DIGITS_MAP = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        // 构造数字-字母映射表
        // 取数字对应的字母时，只需要减2作为下标即可
        // 计算结个个数
        int resultSize = digits.length() > 0 ? 1 : 0;
        for (int i = 0; i < digits.length(); ++i) {
            resultSize *= DIGITS_MAP[digits.charAt(i) - '2'].length();
        }
        // 提前分配结果
        List<char[]> result = new ArrayList<>(resultSize);
        for (int i = 0; i < resultSize; ++i) {
            result.add(new char[digits.length()]);
        }
        // 每个字母应该出现的次数
        int appearanceEachChar = resultSize;
        // 一次循环填充一个数字对应字母的位置
        for (int i = 0; i < digits.length(); ++i) {
            // 每个字母出现的次数由后面的数字组决定
            String digitChars = DIGITS_MAP[digits.charAt(i) - '2'];
            appearanceEachChar /= digitChars.length();
            // 最后一个数字出现次数修正
            // 其出现的列数即为数字的位置
            char[] digitCharArray = digitChars.toCharArray();
            for (int charPos = 0; charPos < digitCharArray.length; ++charPos) {
                // 每经过appearanceEachChar次就切换到下一个字母
                for (int j = charPos * appearanceEachChar; j < resultSize; j += appearanceEachChar * digitCharArray.length) {
                    for (int k = 0; k < appearanceEachChar; ++k) {
                        // 取出对应位置的char数组，填入正确的字母
                        // char数组的位置为: 字母的位置 * 字母出现的次数
                        // 字符对应的位置就是数字的位置(即列)
                        result.get(j + k)[i] = digitCharArray[charPos];
                    }
                }
            }
        }

        return result.stream().map(String::new).collect(Collectors.toList());
    }

    public static List<String> combinations(String digits, List<char[]> results) {
        // 只有一个数字，其组合就是该数字对应的字母
        if (digits.length() == 1) {
            List<String> result = new ArrayList<>(DIGITS_MAP[digits.charAt(0) - '2'].length());
            String chars =  DIGITS_MAP[digits.charAt(0) - '2'];
            for (int i = 0; i < chars.length(); ++i) {
                result.add(chars.substring(i, i + 1).intern());
            }
            return result;
        } else if (digits.length() == 0){
            return Collections.emptyList();
        } else {
            // 求解前面n - 1的集合，以例在最后添加最后一个数字的组合
            List<String> subSets = combinations(digits.substring(0, digits.length() - 1), results);

            String chars = DIGITS_MAP[digits.charAt(digits.length() - 1) - '2'];
            for (int i = 0; i < chars.length(); ++i) {

            }
        }
        return null;
    }

    public static void main(String[] args) {
        assert letterCombinations("").size() == 0;
        System.out.println(" = [" + letterCombinations("").stream().collect(Collectors.joining(",")) + "]");
        System.out.println("2 = [" + letterCombinations("2").stream().collect(Collectors.joining(",")) + "]");
        System.out.println("23 = [" + letterCombinations("23").stream().collect(Collectors.joining(",")) + "]");
        System.out.println("234 = [" + letterCombinations("234").stream().collect(Collectors.joining(",")) + "]");
    }
}
