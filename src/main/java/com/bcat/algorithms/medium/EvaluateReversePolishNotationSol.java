package com.bcat.algorithms.medium;

import java.util.function.BiFunction;

/**
 * Solution for leetcode - 150 - Evaulate Reverse Polish Notation.
 */
public class EvaluateReversePolishNotationSol {
    private static final BiFunction<Integer, Integer, Integer>[] ops = new BiFunction[6];
    static {
        ops[0] = (i, j) -> i * j;
        ops[1] = Integer::sum; ;
        ops[3] = (i, j) -> i - j;
        ops[5] = (i, j) -> i / j;
    }

    public int evalRPN(String[] tokens) {
        int[] operands = new int[tokens.length];
        int lastIndex = 0;
        for (String token : tokens) {
            char firstCh = token.charAt(0);
            if ((firstCh >= '0' && firstCh <= '9') || token.length() > 1) {
                operands[lastIndex++]  = Integer.parseInt(token);
            } else {
                int op2 = operands[--lastIndex];
                int op1 = operands[--lastIndex];
                operands[lastIndex++] = ops[firstCh - '*'].apply(op1, op2);
            }
        }
        return operands[lastIndex];
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotationSol sol = new EvaluateReversePolishNotationSol();
        String[] tokens;

        tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(sol.evalRPN(tokens));

        tokens = new String[]{"4","13","5","/","+"};
        System.out.println(sol.evalRPN(tokens));

        tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(sol.evalRPN(tokens));
    }
}
