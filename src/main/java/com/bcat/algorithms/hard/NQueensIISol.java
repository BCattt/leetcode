package com.bcat.algorithms.hard;

import java.util.Objects;

/**
 * Solution for Leetcode Algorithms 52-N Queens II.
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
public class NQueensIISol {
    public static int totalNQueens(int n) {
        int[][] board = new int[n][n];
        int[] result = new int[1];
        solveBacktracking(board, 0, 0, result);
        return result[0];
    }
    private static void solveBacktracking(int[][] board, int row, int col, int[] total) {
        if (row >= board.length && col >= board.length) {
            return;
        }

        if (col >= board.length) {
            // 本行已经处理完了, 跳到下一行
            solveBacktracking(board, row + 1, 0, total);
        }
        for (int j = col; j < board.length; ++j) {
            if (board[row][j] == 0 && pawn(board, row, j)) {
                // 找到一个解, 总数加1
                if (row == board.length - 1) {
                    ++total[0];
                    break;
                }
                board[row][j] = 1;
                // 这个格子可以放queen, 则继续尝试下一行
                solveBacktracking(board, row + 1, 0, total);
                // 将此处的queen取消
                board[row][j] = 0;
            }
        }
    }

    /**
     * 判断可否将queen放置在(i,j)处.
     * @param board 棋盘
     * @param i 行号
     * @param j 列号
     * @return
     */
    private static boolean pawn(int[][] board, int i, int j) {
        // 所在行, 列不能有queen
        for (int col = 0; col < board.length; ++col) {
            if (col != j && board[i][col] == 1) {
                return false;
            }
        }
        for (int row = 0; row < board.length; ++row) {
            if (row != i && board[row][j] == 1) {
                return false;
            }
        }

        // 斜线不能有queen
        // 左下
        for (int row = i + 1, col = j - 1; row < board.length && col >= 0; ++row, --col) {
            if (board[row][col] == 1) {
                return false;
            }
        }
        // 右上
        for (int row = i - 1, col = j + 1; row >= 0 && col < board.length; --row, ++col) {
            if (board[row][col] == 1) {
                return false;
            }
        }
        // 左上
        for (int row = i - 1, col = j - 1; row >= 0 && col >= 0; --row, --col) {
            if (board[row][col] == 1) {
                return false;
            }
        }
        // 右下
        for (int row = i + 1, col = i + 1; row < board.length && col < board.length; ++row, ++col) {
            if (board[row][col] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
