package com.bcat.algorithms.easy;

import java.util.Arrays;

public class ReshapeTheMatrixSol {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int elements = nums.length * nums[0].length;
        if (elements != r * c) {
            return nums;
        }
        int posInNewMatrix = 0;
        int[][] result = new int[r][c];
        for (int[] numA : nums) {
            for (int num : numA) {
                result[posInNewMatrix / c][posInNewMatrix % c] = num;
                ++posInNewMatrix;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ReshapeTheMatrixSol sol = new ReshapeTheMatrixSol();
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        System.out.println(Arrays.deepToString(sol.matrixReshape(matrix, 1, 4)));
        System.out.println(Arrays.deepToString(sol.matrixReshape(matrix, 2, 4)));
    }
}
