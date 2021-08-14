package com.bcat.algorithms.easy;

/**
 * Solution for leetcode 1812 - Determine Color of a Chessboard Square.
 */
public class DetermineColorOfAChessboardSquareSol {
    public boolean squareIsWhite(String coordinates) {
        int dimension = 8;
        boolean[][] board = new boolean[8][8];
        board[0][0] = false;
        for (int i = 1; i < dimension; ++i) {
            board[0][i] = !board[0][i-1];
        }
        for (int i = 1; i < dimension; ++i) {
            for (int j = 0; j < dimension; ++j) {
                board[i][j] = !board[i-1][j];
            }
        }
        char row = coordinates.charAt(0);
        char col = coordinates.charAt(1);
        return board[row - 'a'][col - '1'];
    }

    public static void main(String[] args) {
        DetermineColorOfAChessboardSquareSol sol = new DetermineColorOfAChessboardSquareSol();
        System.out.println(sol.squareIsWhite("a1"));
        System.out.println(sol.squareIsWhite("a2"));
        System.out.println(sol.squareIsWhite("h3"));
        System.out.println(sol.squareIsWhite("h2"));
        System.out.println(sol.squareIsWhite("c7"));
    }
}

