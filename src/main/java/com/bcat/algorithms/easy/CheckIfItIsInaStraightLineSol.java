package com.bcat.algorithms.easy;

import java.math.BigDecimal;

/**
 * Leetcode 1232-Check if it is in a Strigh line.
 *
 */
public class CheckIfItIsInaStraightLineSol {
    public boolean checkStraightLine(int[][] coordinates) {
        // 取2点, 求斜率
        double slope = slopePositive(coordinates[0], coordinates[1]);
        for (int i = 2; i < coordinates.length; ++i) {
            if (0 != Double.compare(slope, slopePositive(coordinates[i], coordinates[0]))) {
                return false;
            }
        }
        return true;
    }

    double slopePositive(int[] coordinate1, int[] coordinate2) {
        if (coordinate1[1] > coordinate2[1]) {
            return ((double) coordinate1[0] - coordinate2[0]) / (coordinate1[1] - coordinate2[1]);
        } else if (coordinate1[1] < coordinate2[1]) {
            return ((double) coordinate2[0] - coordinate1[0]) / (coordinate2[1] - coordinate1[1]);
        } else {
            return Double.NaN;
        }
    }

    public static void main(String[] args) {
        CheckIfItIsInaStraightLineSol sol = new CheckIfItIsInaStraightLineSol();
        System.out.println(sol.checkStraightLine(new int[][]{
                {1, -8}, {2, -3}, {1, 2}
        }));
        System.out.println(sol.checkStraightLine(new int[][]{
                {2, 4}, {2,5}, {2, 8}
        }));
        System.out.println(sol.checkStraightLine(new int[][]{
                {1, 2}, {2,3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}
        }));
        System.out.println(sol.checkStraightLine(new int[][]{
                {1,1}, {2,2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}
        }));
    }
}
