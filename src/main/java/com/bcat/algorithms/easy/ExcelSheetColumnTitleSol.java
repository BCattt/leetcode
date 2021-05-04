package com.bcat.algorithms.easy;

/**
 * Solution for leetcode 168 - Excel Sheet Column Title.
 */
public class ExcelSheetColumnTitleSol {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        int cn = columnNumber;
        while (cn > 26) {
            int mod = cn % 26;
            cn /= 26;
            if (mod == 0) {
                result.append('Z');
                --cn;
            } else {
                result.append((char) ('A' + (mod - 1)));
            }
        }

        if (cn > 0) {
            result.append((char) ('A' + (cn - 1)));
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitleSol sol = new ExcelSheetColumnTitleSol();
        int columnNumber;

        columnNumber = 1;
        System.out.println(columnNumber + ": " + sol.convertToTitle(columnNumber));

        columnNumber = 26;
        System.out.println(columnNumber + ": " + sol.convertToTitle(columnNumber));

        columnNumber = 27;
        System.out.println(columnNumber + ": " + sol.convertToTitle(columnNumber));

        columnNumber = 28;
        System.out.println(columnNumber + ": " + sol.convertToTitle(columnNumber));

        columnNumber = 52;
        System.out.println(columnNumber + ": " + sol.convertToTitle(columnNumber));

        columnNumber = 701;
        System.out.println(columnNumber + ": " + sol.convertToTitle(columnNumber));

        columnNumber = 2147483647;
        System.out.println(columnNumber + ": " + sol.convertToTitle(columnNumber));
    }
}
