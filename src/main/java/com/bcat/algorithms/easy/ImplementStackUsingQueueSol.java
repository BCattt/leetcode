package com.bcat.algorithms.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution for leetcode 225 - Implement Stack Using Queues.
 */
public class ImplementStackUsingQueueSol {
    static class MyStack {
        private Deque<Integer> queue;
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.offerLast(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.pollLast();
        }

        /** Get the top element. */
        public int top() {
            return queue.peekLast();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
