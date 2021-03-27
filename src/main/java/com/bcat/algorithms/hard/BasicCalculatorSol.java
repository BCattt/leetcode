package com.bcat.algorithms.hard;

import java.util.Stack;

public class BasicCalculatorSol {
    public int calculate(String s) {
        // 操作符栈
        Stack<Character> operators = new Stack<>();

        char[] chA = s.toCharArray();
        int result = 0;
        int sign = 1;
        for (int i = 0; i < chA.length;) {
            if (chA[i] == ' ') {
                // 空格则跳过
                ++i;
            } else if (chA[i] == '(') {
                // 同一优先级的符号入栈
                operators.push(chA[i]);
                ++i;
            } else if (chA[i] == '-') {
                sign = -1;
                ++i;
            } else if (chA[i] == '+') {
                sign = 1;
                ++i;
            } else if (chA[i] == ')') {
                // 遇到右括号, 则计算至最近的左括号
                operators.pop();
                ++i;
            } else {
                long digit = 0L;
                while (i < chA.length && chA[i] >= '0' && chA[i] <= '9') {
                    digit = digit * 10 + chA[i] - '0';
                    ++i;
                }
                result += digit * sign;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        BasicCalculatorSol sol = new BasicCalculatorSol();
        System.out.println(sol.calculate("1 + 1"));
        System.out.println(sol.calculate("2-1 + 2"));
        System.out.println(sol.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(sol.calculate("(1-(4+5+2)-3)+(6+8)"));
    }
}
