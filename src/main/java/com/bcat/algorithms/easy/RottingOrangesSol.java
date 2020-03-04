package com.bcat.algorithms.easy;

/**
 * Solution for LeetCode problem 994. Rotting Oranges
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 *Example 1:
 *
 *
 *
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 *  
 *
 * Note:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 *
 * 解题思路:
 * 持续扫描矩阵，查找当前已经坏掉的橘子，并以此橘子为中心向前后左右扩展，标记相应
 * 的橘子为坏掉的橘子，如果扩展成功，则表示该分钟内仍然有橘子坏掉，继续扫描；
 * ... 直到坏掉的橘子数不再变化时，统计橘子数是否与坏掉的橘子数相等，如果相等，则
 * 扫描次数即为分钟数；如果不相等，则无法使所有橘子坏掉。
 *
 * @author <a href="zjebusiness@gmail.com">赵峻</a>
 */
public class RottingOrangesSol {
    public static int orangeRotting(int[][] grid) {
        // 增加一个二维数组，用来记录每个位置的橘子是否发生了腐烂，如果发生了腐烂，
        // 则本轮不再测试其传染性
        boolean[][] statusArray = new boolean[grid.length][grid[0].length];

        // 是否有新的橘子坏掉
        boolean rottenExpanded = true;
        // 所有橘子坏掉用时
        int minutes = 0;
        while (rottenExpanded) {
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    statusArray[i][j] = false;
                }
            }
            rottenExpanded = false;
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    // 发现一个坏橘子, 向4个方向传染
                    if (grid[i][j] == 2 && statusArray[i][j] == false) {
                        // 向左
                        if (j - 1 >= 0) {
                            // 只有好橘子才会传染
                            if (grid[i][j-1] == 1) {
                                rottenExpanded = true;
                                grid[i][j-1] = 2;
                                statusArray[i][j-1] = true;
                            }
                        }
                        // 向右
                        if (j + 1 < grid[i].length) {
                            if (grid[i][j+1] == 1) {
                                rottenExpanded = true;
                                grid[i][j+1] = 2;
                                statusArray[i][j+1] = true;
                            }
                        }
                        // 向上
                        if (i - 1 >= 0) {
                            if (grid[i-1][j] == 1) {
                                rottenExpanded = true;
                                grid[i-1][j] = 2;
                                statusArray[i-1][j] = true;
                            }
                        }
                        // 向下
                        if (i + 1 < grid.length) {
                            if (grid[i+1][j] == 1) {
                                rottenExpanded = true;
                                grid[i+1][j] = 2;
                                statusArray[i+1][j] = true;
                            }
                        }
                    }
                }
            }
            // 只有发生了传染才增加分钟数
            minutes += (rottenExpanded ? 1 : 0);
        }// while
        // 橘子总数和坏掉的橘子数
        int oranges = 0, rottenOranges = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                switch (grid[i][j]) {
                    case 2:
                        ++rottenOranges;
                    case 1:
                        ++oranges;
                }
            }
        }
        return oranges == rottenOranges ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] array = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(orangeRotting(array));

        array = new int[][]{{0,2}};
        System.out.println(orangeRotting(array));

        array = new int[][]{
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        System.out.println(orangeRotting(array));

        array = new int[][]{
            {2},
            {1}
        };
        System.out.println(orangeRotting(array));

        array = new int[][]{
            {2}
        };
        System.out.println(orangeRotting(array));

        array = new int[][]{
            {2, 0},
            {0, 2}
        };
        System.out.println(orangeRotting(array));
    }
}
