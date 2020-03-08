package com.bcat.comp.dw21.easy;

public class OddString {
    public static String generateTheString(int n) {
        // 如果n是奇数，直接返回全部a， 否则返回n-1个a和一个b
        StringBuilder result = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; ++i) {
                result.append("a");
            }
            result.append("b");
        } else {
            for (int i = 0; i < n; ++i) {
                result.append("a");
            }
        }
        return result.toString();
    }
}
