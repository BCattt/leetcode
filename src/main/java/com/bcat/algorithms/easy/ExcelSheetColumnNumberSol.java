package com.bcat.algorithms.easy;

/**
 * Solution for leetcode 171 - Excel Sheet Column Number.
 */
public class ExcelSheetColumnNumberSol {
    public int titleToNumber(String columnTitle) {
        long result = 0L;
        long multiply = 1L;
        int n = columnTitle.length();
        for (int i = n - 1; i >= 0; --i) {
            result += multiply * (columnTitle.charAt(i) - 'A' + 1);
            multiply *= 26;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumberSol sol = new ExcelSheetColumnNumberSol();
        String columnTitle;

        columnTitle = "A";
        System.out.println(columnTitle + ": " + sol.titleToNumber(columnTitle));

        columnTitle = "AB";
        System.out.println(columnTitle + ": " + sol.titleToNumber(columnTitle));

        columnTitle = "ZY";
        System.out.println(columnTitle + ": " + sol.titleToNumber(columnTitle));

        columnTitle = "FXSHRXW";
        System.out.println(columnTitle + ": " + sol.titleToNumber(columnTitle));
    }
}
