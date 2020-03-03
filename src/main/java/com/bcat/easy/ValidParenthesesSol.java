package com.bcat.easy;

import java.util.Stack;

/**
 * Solution for LeetCode problem 20. Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * <b>Example 1:</b>
 * {@code
 *   Input: "()"
 *   Output: true
 * }
 *
 * <b>Example 2:</b>
 * {@code
 *   Input: "()[]{}"
 *   Output: true
 * }
 *
 * <b>Example 3:</b>
 * {@code
 *   Input: "(]"
 *   Output: false
 * }
 *
 * <b>Example 4:</b>
 * {@code
 *   Input: "([)]"
 *   Output: false
 * }
 *
 * <b>Example 5:</b>
 * {@code
 *   Input: "{[]}"
 *   Output: true
 * }
 * <p>
 *     解题思路：
 *     1. 使用栈来判断
 *        遇到左括号就压栈, 遇到右括号就出栈, 如果无法出栈，则状态错误。
 *        如果所有字符处理完成，则栈大小应为0
 * </p>
 */
public class ValidParenthesesSol {
    public static boolean isValid(String s) {
        // 使用char数组模拟栈(栈中最多有s.length个元素, 如果超过这个数, 则说明括号肯定无效)
        int stackCapacity = (s.length() >> 1) + 2;
        char[] stackArray = new char[stackCapacity];
        // 当前栈顶(第一个位置不保存任何元素)
        int pos = 0;
        char ch = '\0';
        for (int i = 0; i < s.length() && pos < stackCapacity; ++i) {
            ch = s.charAt(i);
            switch (ch) {
                // 如果是左括号, 则直接压栈
                case '(':
                case '[':
                case '{':
                    stackArray[++pos] = ch;
                    break;
                // 如果是右括号, 则取栈顶元素比较, 如果是对应的左括号, 则弹线;
                // 否则直接返回false, 不匹配
                case ')':
                    if (stackArray[pos] == '(') {
                        --pos;
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (stackArray[pos] == '[') {
                        --pos;
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (stackArray[pos] == '{') {
                        --pos;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return pos == 0;
    }

    public static void main(String[] args) {
        System.out.println("\"\" = " + isValid(""));
        System.out.println("( = " + isValid("("));
        System.out.println(") = " + isValid(")"));
        System.out.println("() = " + isValid("()"));
        System.out.println("()[ = " + isValid("()["));
        System.out.println("()] = " + isValid("()]"));
        System.out.println("()[]{} = " + isValid("()[]{}"));
        System.out.println("(] = " + isValid("(]"));
        System.out.println("([)] = " + isValid("([)]"));
        System.out.println("{[]} = " + isValid("{[]}"));
        System.out.println("{[()]} = " + isValid("{[()]}"));
    }
}

