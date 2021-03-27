package com.bcat.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixSol {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int n = rows * cols;
        List<Integer> result = new ArrayList<>(n);

        int rTop = 0;
        int cLeft = 0;

        int r = 0;
        int c = 0;
        int movDir = 0; // 0 - right, 1 - down, 2 - left, 3 - up
        while (result.size() < n) {
            switch (movDir) {
                case 0:
                    // move right
                    while (c < cols) {
                        result.add(matrix[r][c++]);
                    }
                    --c;
                    ++rTop;
                    movDir = 1;
                    break;
                case 1:
                    ++r;
                    // move down
                    while (r < rows) {
                        result.add(matrix[r++][c]);
                    }
                    --r;
                    --cols;
                    movDir = 2;
                    break;
                case 2:
                    // move left
                    --c;
                    while (c >= cLeft) {
                        result.add(matrix[r][c--]);
                    }
                    ++c;
                    --rows;
                    movDir = 3;
                    break;
                case 3:
                    // move up
                    --r;
                    while (r >= rTop) {
                        result.add(matrix[r--][c]);
                    }
                    ++r;
                    ++c;
                    ++cLeft;
                    movDir = 0;
                    break;

            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrixSol sol = new SpiralMatrixSol();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(sol.spiralOrder(matrix));

        matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(sol.spiralOrder(matrix));

        matrix = new int[][]{
                {1}
        };
        System.out.println(sol.spiralOrder(matrix));

        matrix = new int[][] {
                {1, 2}
        };
        System.out.println(sol.spiralOrder(matrix));
        matrix = new int[][] {
                {1},
                {2}
        };
        System.out.println(sol.spiralOrder(matrix));

        matrix = new int[][] {
                {1},
                {2},
                {3},
        };
        System.out.println(sol.spiralOrder(matrix));

        matrix = new int[][] {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        System.out.println(sol.spiralOrder(matrix));

        matrix = new int[][] {
                {1, 2},
                {3, 4}
        };
        System.out.println(sol.spiralOrder(matrix));

        matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(sol.spiralOrder(matrix));
    }
}
