package com.bcat.algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromePartitioningSol {
    public List<List<String>> partition(String s) {
        // 先找到所有回文串, 尽量长, 然后以这些回文串为分隔点, 每次对回文串进行分隔, 直接回文串长度为0或1时, 分隔完毕, 拼接后面所有回文串
        // 的分隔后, 形成一种分隔
        return null;
    }

    /**
     * 求解字符串的所有子回文串.
     *
     * @param s 待求解字符串
     * @return 所有回文子串
     */
    private List<String> palindromes(String s) {
        List<String> results = new ArrayList<>();
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chs[0]);
        int pS = 0;
        int pE = 0;
        for (int i = 1; i < chs.length; ++i) {
            if (chs[i] == stack.peek()) {
                stack.pop();
            }
        }
        return null;
    }
}
