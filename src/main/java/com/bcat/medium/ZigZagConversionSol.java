package com.bcat.medium;

/**
 * Solution for leetcode problem #6 ZigZag Conversion
 *
 * <p>
 *     Problem description:
 *     The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *{@code
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * }
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * {@code
 *   P     I    N
 *   A   L S  I G
 *   Y A   H R
 *   P     I
 * }
 * </p>
 * ZigZag模式即字母以倒N的形式排列，比如PAYPALISIRING以4行的ZigZag模式显示如下：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 题目要求返回逐行的结果，因此，可以通过计算结果中每个字母对应原字符串的位置直接得到，不需要构造
 * 矩阵。
 */
public class ZigZagConversionSol {
    public static String convert(String s, int numRows) {
        // 只有一行，结果就是其本身
        if (1 == numRows) {
            return s;
        }
        byte[] origin = s.getBytes();
        int len = origin.length;
        byte[] result = new byte[s.length()];
        // 原字符串当前位置
        int pos;
        // 结果字符串当前位置
        int copyPos = 0;
        // 拷贝步进，以此步进来决定拷贝原字符串的位置
        // 初始位置为2 * (numRows - 1), 比如如是4行, 则步进就是6
        int step = 2 * (numRows - 1);
        // 计算结果矩阵中的列数
        // 如果不是第行一个字母(s.length() > numRows)，则使用步进计算列数
        // (s.length() - numRows) / step，并向上取整+1，否则，只有一列
        // 比如如果是4行，对于PAYPALISIRING有6列
        int columns = len > numRows ? Double.valueOf(Math.ceil((len - numRows) / (step * 1.0))).intValue() + 1 : 1;
        // 逐行计算每个字符在原字符串中的位置
        for (int row = 0; row < numRows; ++row) {
            // 对于第一行和最后一行，其步进是step
            if (0 == row % (numRows - 1)) {
                for (int col = 0; col < columns; ++col) {
                    pos = row + col * step;
                    if (pos < len) {
                        result[copyPos++] = origin[pos];
                    }
                }
            // 对于中间的行，其步进随着行数的增加会发生变化
            } else {
                for (int col = 0; col < columns; ++col) {
                    // 对于中间行，每列每次拷贝再次，位置分别为row + col * step
                    // 下一个位置再加上step - 2 * row
                    pos = row + col * step;
                    if (pos < len) {
                        result[copyPos++] = origin[pos];
                    }
                    pos += step - 2 * row;
                    if (pos < len) {
                        result[copyPos++] = origin[pos];
                    }
                }
            }
        }
        return new String(result);
    }
}
