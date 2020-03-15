package com.bcat.algorithms.hard;

import java.util.Stack;

/**
 * Solution for LeetCode Algorithm problem 32-Longest Valid Parentheses.
 *
 * <p>Given a string containing just the characters '(' and ')', find the length
 * of the longest valid (well-formed) parentheses substring.
 *
 * <p><b>Example 1:</b>
 * {@code
 *   Input: "(()"
 *   Output: 2
 *   Explanation: The longest valid parentheses substring is "()"
 * }
 *
 * <p><b>Example 2:</b>
 * {@code
 *   Input: ")()())"
 *   Output: 4
 *   Explanation: The longest valid parentheses substring is "()()"
 * }
 * <p>解题思路:
 * 遍历括号序列, 如果遇到一个有效括号序列, 则需要判断上一个有效括号序列的开始位置, 如果是
 * 连续的, 则当前有效序列需要加上上一个有效序列, 然后计算最长有效序列.
 * 可以使用一个栈来记录每个有效序列起始位置, 当当前有效序列结束时, 判断是否需要加上之前的
 * 有效序列(就是当前右括号下标 - 上一个有效左括号下标).
 * 先在栈中压入一个无效的下标-1.
 * 对于每一个左括号, 其下标入栈; 对于每一个右括号, 弹出栈顶元素, 如果此时栈空了, 说明遇到了
 * 连续的无效右括号, 此时将右括号下标入栈; 否则, 栈不空时, 说明括号仍然是有效的, 计算
 * 当前下标i - 栈顶元素的长度即为当前最长的有效序列长度.
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class LongestValidParenthesesSol {
    public static int longestValidParentheses(String s) {
        int maxValid = 0;
        Stack<Integer> stack = new Stack<>();
        // 防止第一个遇到的是)栈空的情况
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            // 如果是左括号, 则下标入栈
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                //
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxValid = Math.max(maxValid, i - stack.peek());
                }
            }
        }
        return maxValid;
    }

    public static void main(String[] args) {
        String s = ")";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = ")";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = "()";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = "((";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = "))";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = "(()";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = "())";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = "(((";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = ")))";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = ")())";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = ")()())";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = "((())))";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = "((()())))";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = "(((((((()";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = "())(()";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = "()(()";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = ")()())";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = "(()(((()";
        System.out.println(s + " = " + longestValidParentheses(s));
        s = "(()()";
        System.out.println(s + " = " + longestValidParentheses(s));
    }
}
