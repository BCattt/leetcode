package com.bcat.algorithms.easy;

/**
 * Solution for LeetCode algorithm problem 836-Rectangle Overlap.
 *
 * <p>A rectangle is represented as a list {@literal [x1, y1, x2, y2]}, where
 * {@literal (x1, y1)} are the coordinates of its bottom-left corner, and
 * {@literal (x2, y2) are} the coordinates of its top-right corner.
 * Two rectangles overlap if the area of their intersection is positive.
 * To be clear, two rectangles that only touch at the corner or edges do not overlap.
 * Given two (axis-aligned) rectangles, return whether they overlap.</p>
 * <p>
 * <p><b>Example 1: </b>
 * <pre>
 *     <b>Input:</b> rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 *     <b>Output:</b> true
 * </pre>
 * </p>
 * <p><b>Example 2: </b>
 *  * <pre>
 *  *     <b>Input:</b> rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 *  *     <b>Output:</b> false
 *  * </pre>
 *  * </p>
 * </p>
 * <p><b>Note:</b>
 * <ol>
 *     <li>Both rectangles rec1 and rec2 are lists of 4 integers.</li>
 *     <li>All coordinates in rectangles will be between -10^9 and 10^9.</li>
 * </ol>
 * </p>
 * <p><b>解题思路:</b>
 * 两个距离最远的点, x轴的距离和y轴的距离如果不小于两个矩形x轴边长的和及y轴连长的和, 则必定重叠.
 * </p>
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class RectangleOverlapSol {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // x轴的距离计算: x轴上最远的两个点之差
        long xDist = Math.max(rec1[2], rec2[2]) - Math.min(rec1[0], rec2[0]);
        // y轴距离计算: y轴上最远的两个点之差
        long yDist = Math.max(rec1[3], rec2[3]) - Math.min(rec1[1], rec2[1]);
        // x轴边长和计算rec1[2] - rec1[0] + rec2[2] - rec2[0]
        long xEdgeSum = rec1[2] - rec1[0];
        xEdgeSum += rec2[2] - rec2[0];
        // y轴边长和计算rec1[3] - rec1[1] + rec2[3] - rec2[1]
        long yEdgeSum = rec1[3] - rec1[1];
        yEdgeSum += rec2[3] - rec2[1];
        if (xDist < xEdgeSum) {
            // 如果x轴的距离小于边长和, 则看y轴是否大于等于, 如果也小于, 则必相交
            if (yDist >= yEdgeSum) {
                return false;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRectangleOverlap(new int[]{0,0,2,2}, new int[]{1,1,3,3}));
        System.out.println(isRectangleOverlap(new int[]{0,0,1,1}, new int[]{1,0,2,1}));
        System.out.println(isRectangleOverlap(new int[]{5,15,8,18}, new int[]{0,3,7,9}));
        System.out.println(isRectangleOverlap(new int[]{-257926405,-680763313,702840196,454409669}, new int[]{-275916328,-417802221,22808107,675629469}));
    }
}
