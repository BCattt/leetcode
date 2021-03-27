package com.bcat.algorithms.medium;

import java.util.Arrays;

/**
 * Solution for leetcode - 73 - Set Matrix Zeroes.
 */
public class SetMatrixZeroesSol {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rowsWithZero = new boolean[m];
        boolean[] colsWithZero = new boolean[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    rowsWithZero[i] = true;
                    colsWithZero[j] = true;
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            if (rowsWithZero[i]) {
                Arrays.fill(matrix[i], 0, n, 0);
            } else {
                for (int j = 0; j < n; ++j) {
                    if (colsWithZero[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        SetMatrixZeroesSol sol = new SetMatrixZeroesSol();
        sol.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

        matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        sol.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
