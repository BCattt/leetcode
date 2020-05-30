package com.bcat.algorithms.easy;

/**
 * Solution for LeetCode Algorithm 155 - Min Stack.
 *
 * <p>Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * <ul>
 *   <li>push(x) -- Push element x onto stack.</li>
 *   <li>pop() -- Removes the element on top of the stack.</li>
 *   <li>top() -- Get the top element.</li>
 *   <li>getMin() -- Retrieve the minimum element in the stack.</li>
 * </ul>
 * </p>
 * <p><b>Example 1:</b><pre>
 *     <b>Input</b>
 *     ["MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"]
 *     [[],[-2],[0],[-3],[],[],[],[]]
 *     <b>Output</b>
 *     [null,null,null,null,-3,null,0,-2]
 *     <b>Explanation</b>
 *     MinStack minStack = new MinStack();
 *     minStack.push(-2);
 *     minStack.push(0);
 *     minStack.push(-3);
 *     minStack.getMin();  // return -3
 *     minStack.pop();
 *     minStack.top();    // return 0
 *     minStack.getMin(); // return -2
 * </pre></p>
 * <p><b>Constraints:</b>
 * <ul><li>Methods {@code pop, top} and {@code getMin} operations will always be
 * called on <b>non-empty</b> stack.</li></ul>
 * </p>
 * <p><b>Solution: </b><pre>
 *     使用数组来维护栈, 记录最小元素地址, 如果push/pop时发生变化, 则更新; 当调用getMin
 * 时, 则重新查找.
 * </pre></p>
 *
 * @date 28/05/2020
 * @author <a href="zjebusiness@gmail.com">BCat</a> 
 */
public class MinStackSol {
    public static class MinStack {
        /**
         * 保存数据
         */
        int[] stack;
        /**
         * 最小值索引
         */
        int minIndex;
        /**
         * 栈顶索引
         */
        int topIndex;
        public MinStack() {
            stack = new int[2];
            minIndex = -1;
            topIndex = -1;
        }
        public void push(int x) {
            if (topIndex >= stack.length - 1) {
                int[] tmp = new int[stack.length * 2];
                System.arraycopy(stack, 0, tmp, 0, stack.length);
                stack = tmp;
            }
            stack[++topIndex] = x;
            // 更新最小值
            if (minIndex == -1 || stack[minIndex] > x) {
                minIndex = topIndex;
            }
        }
        public void pop() {
            if (topIndex >= 0) {
                --topIndex;
            }
            // 重新维护最小值
            // 当前最小值是否有效, 如果无效, 则重新查找最小值
            if (minIndex > topIndex) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i <= topIndex; ++i) {
                    if (stack[i] <= min) {
                        minIndex = i;
                        min = stack[i];
                    }
                }
            }
        }
        public int top() {
            if (topIndex >= 0) {
                return stack[topIndex];
            } else {
                return 0;
            }
        }
        public int getMin() {
            return stack[minIndex];
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
