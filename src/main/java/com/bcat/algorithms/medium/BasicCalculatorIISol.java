package com.bcat.algorithms.medium;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorIISol {
    public int calculate(String s) {
        Deque<Character> operators = new LinkedList<>();
        Deque<Integer> operands = new LinkedList<>();
        char[] chA = s.toCharArray();
        int n = chA.length;
        for (int i = 0; i < n;) {
            switch (chA[i]) {
                case ' ':
                    ++i;
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    operators.addLast(chA[i]);
                    ++i;
                    break;
                default:
                    int digit = 0;
                    while (i < n && chA[i] >= '0' && chA[i] <= '9') {
                        digit = digit * 10 + chA[i] - '0';
                        ++i;
                    }
                    if (!operators.isEmpty()) {
                        if (operators.peekLast() == '*') {
                            operands.addLast(operands.pollLast() * digit);
                            operators.pollLast();
                        } else if (operators.peekLast() == '/') {
                            operands.addLast(operands.pollLast() / digit);
                            operators.pollLast();
                        } else {
                            operands.addLast(digit);
                        }
                    } else {
                        operands.addLast(digit);
                    }
                break;
            }
        }
        int result = operands.pollFirst();
        while (!operators.isEmpty()) {
            if (operators.peek() == '+') {
                result += operands.pollFirst();
            } else if (operators.peek() == '-') {
                result -= operands.pollFirst();
            }
            operators.pollFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculatorIISol sol = new BasicCalculatorIISol();
        System.out.println(sol.calculate("3+2*2"));
        System.out.println(sol.calculate("3/2"));
        System.out.println(sol.calculate("3"));
        System.out.println(sol.calculate("3+5 / 2"));
    }
}
