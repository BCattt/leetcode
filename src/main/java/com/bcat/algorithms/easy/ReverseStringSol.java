package com.bcat.algorithms.easy;

import java.util.Arrays;

/**
 * Solution for leetcode 344 - Reverse String.
 */
public class ReverseStringSol {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l <= r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            ++l;
            --r;
        }
    }

    public static void main(String[] args) {
        ReverseStringSol sol = new ReverseStringSol();
        char[] s;
        s = new char[]{'h', 'e', 'l', 'l', 'o'};
        sol.reverseString(s);
        System.out.println(Arrays.toString(s));

        s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        sol.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
