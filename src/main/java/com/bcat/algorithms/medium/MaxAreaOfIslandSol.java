package com.bcat.algorithms.medium;

/**
 * Solution for LeetCode algorithm problem 695-Max Area of Island.
 *
 * <p>
 * Given a non-empty 2D array {@literal grid} of 0's and 1's, an island is a
 * group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are
 * surrounded by water. Find the maximum area of an island in the given 2D array.
 * (If there is no island, the maximum area is 0.)
 * </p>
 * <p>
 * <b>Example 1:</b>
 * {@literal
 *   [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *    [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *    [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *    [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *    [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *    [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *    [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *    [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * }
 * Given the above grid, return 6. Note the answer is not 11, because the island
 * must be connected 4-directionally.
 * </p>
 * <p>
 * <b>Example 2:</b>
 * {@literal
 *   [[0,0,0,0,0,0,0,0]]
 * }
 * Given the above grid, return 0.
 * </p>
 * <p>
 * <b>Note: </b>The length of each dimension in the given grid does not exceed 50.
 * </p>
 *
 * <p>
 * <b>解题思路: </b>
 * <p>
 * <b>思路1: </b>
 * 对于每个节点的最大岛屿面积, 如果它是一个岛屿, 则是其四个方向岛屿面积+1之和. 那么, 我们
 * 以每个岛屿为中心, 分别向四个方向求解岛屿面积即可
 *
 * </p>
 * </p>
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class MaxAreaOfIslandSol {
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 1) {
                    //以此为中心，向四周扩散
                    area = area(grid, i, j);
                    maxArea = maxArea > area ? maxArea : area;
                }
            }
        }
        return maxArea;
    }

    /**
     * 求解某个节点为中心的最大岛屿面积
     * @param grid 搜索数组
     * @param i 起始行
     * @param j 起始列
     * @return
     */
    static int area(int[][] grid, int i, int j) {
        // 如果超出边界或已经访问过, 则其面积为0
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        // 对于已经计算过的岛屿, 将其状态置为0
        grid[i][j] = 0;
        return 1 + area(grid, i + 1, j) + area(grid, i - 1, j) + area(grid, i, j + 1) + area(grid, i,j - 1);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(grid));

        grid = new int[][]{
            {0,0,0,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(grid));

        grid = new int[][]{
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int maxAreas = maxAreaOfIsland(grid);
        System.out.println(maxAreas);

    }
}
