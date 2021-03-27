package com.bcat.algorithms.medium;

import java.util.Deque;
import java.util.LinkedList;

public class VerifyPreorderSerializationOfaBinaryTreeSol {
    public boolean isValidSerialization(String preorder) {
        Deque<Integer> innerNodes = new LinkedList<>();
        Deque<Character> leaves = new LinkedList<>();
        if (preorder.length() == 1 && preorder.charAt(0) == '#') {
            return true;
        }
        if (preorder.startsWith("#")) {
            return false;
        }
        char[] chA = preorder.toCharArray();
        int n = chA.length;
        for (int i = 0; i < n;) {
            switch (chA[i]) {
                case ',':
                    ++i;
                    break;
                case '#':
                    if (!leaves.isEmpty() && !innerNodes.isEmpty()) {
                        // 已经有一个叶子节点, 则两个叶子节点出栈，同时，一个数字出栈
                        // 表示一棵子树检查完成
                        innerNodes.pollLast();
                        if (innerNodes.isEmpty()) {
                            leaves.pollLast();
                        }
                    } else {
                        // 只检测到一个叶子节点, 则入栈
                        leaves.push('#');
                    }
                    ++i;
                    break;
                default:
                    int digit = 0;
                    while (i < n && chA[i] >= '0' && chA[i] <= '9') {
                        digit = digit * 10 + chA[i] - '0';
                        ++i;
                    }
                    innerNodes.push(digit);
                    break;
            }
        }
        return innerNodes.isEmpty() && leaves.isEmpty();
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationOfaBinaryTreeSol sol = new VerifyPreorderSerializationOfaBinaryTreeSol();
        System.out.println(sol.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(sol.isValidSerialization("1,#"));
        System.out.println(sol.isValidSerialization("1,#,#"));
        System.out.println(sol.isValidSerialization("9,#,#,1"));
        System.out.println(sol.isValidSerialization("1,#,#,#,#"));
        System.out.println(sol.isValidSerialization("1,2,#,#,#"));
        System.out.println(sol.isValidSerialization("#"));
        System.out.println(sol.isValidSerialization("#,7,6,9,#,#,#"));
        // "9,3,4,#,#,1,#,#,#,2,#,6,#,#"
        System.out.println(sol.isValidSerialization("9,3,4,#,#,1,#,#,#,2,#,6,#,#"));
    }
}
