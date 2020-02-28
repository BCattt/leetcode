package com.bcat.medium;

/**
 * Solution for LeetCode problem 11.Container With Most Water
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 * 这个问题就是计算两个x轴上的点x1和x2距离差以及min(x1高度a1, x2高度a2)的最大面积(即(x1 - x2) * min(a1, a2)
 * 分别从x0和xe开始向中间移动，不断计算移动过程中的面积，直到x0和xe相遇，得到最大面积
 */
public class ContainerWithMostWaterSol {
    public static int maxArea(int[] height) {
        int startPos = 0, endPos = height.length - 1;
        int maxArea = 0, currArea = 0;
        while (startPos < endPos) {
            // 如果x1高度小于x2高度，则应向前移动x1，以寻找可能更大的面积
            if (height[startPos] < height[endPos]) {
                currArea = height[startPos] * (endPos - startPos);
                ++startPos;
            // x2高度小于x1高度，则应向后移动x2，以寻找可能更大的面积
            } else {
                currArea = height[endPos] * (endPos - startPos);
                --endPos;
            }
            if (currArea > maxArea) {
                maxArea = currArea;
            }
        }
        return maxArea;
    }
}
