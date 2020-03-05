package com.bcat.algorithms.medium;

/**
 * Solution for LeetCode problem 22-Generate Parentheses.
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <pre>
 * {@code
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * }
 * </pre>
 *
 * <p>解题思路:
 * n = 1, 1个组合()
 * n = 2, 2个组()(), (())
 * n = 3, 5个组合()()(), (())(), ()(()), (()()), ((()))
 * n = 4:
 * ()()() -> ()()()(), (())()(), ()(())(), ()()(())
 * (())() -> (()())(), ((()))(), (()())(), (())()(), (())(())
 * ()(()) -> ()()(()), (())(()), ()(()()), ()((())), ()(()()), ()(())()
 * (()()) -> (()()()), ((())()), (()(()))
 * ((())) ->
 * 由于要求括号是有效的，因此，对于任意n个括号，其结果集为在n-1的结果集中可插入括号位置的左边一半位置插入一个完整括号
 * @author <a href="zjebusiness@gmail.com">赵峻</a>
 */
public class GenerateParenthesesSol {
}
