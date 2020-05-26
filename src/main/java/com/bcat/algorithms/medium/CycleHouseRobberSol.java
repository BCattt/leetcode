package com.bcat.algorithms.medium;

/**
 * Solution for LeetCode algorithm problem 213 - House Robber II.
 *
 * <p>You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have security system connected and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * </p>
 * <p><b>Example 1: </b><pre>
 *   <b>Input: </b>[2,3,2]
 *   <b>Output: </b>3
 *   <b>Explanation: </b>You cannot rob house 1 (money = 2) and then rob house 3
 *                (money = 2), because they are adjacent houses.
 * </pre></p>
 * <p><b>Example 2: </b><pre>
 *   <b>Input: </b>[1,2,3,1]
 *   <b>Output: </b>4
 *   <b>Explanation: </b>Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *                Total amount you can rob = 1 + 3 = 4.
 * </pre></p>
 * <p><b>Solution: </b><pre>
 *     与HouseRobber相似, 只不过我们不能同时偷窥房间1和房间n, 因此, 从房间1 ~ 房间n计算一趟,
 * 从房间2 ~ 房间n计算一遍, 取最大值即可.
 * </pre></p>
 */
public class CycleHouseRobberSol {
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robDp(nums, 0, nums.length - 1), robDp(nums, 1, nums.length));
    }

    public static int robDp(int[] nums, int start, int end) {
        int preMax = 0;
        int curMax = 0;
        for (int i = start; i < end; ++i) {
            int tmp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = tmp;
        }
        return curMax;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1}));
        System.out.println(rob(new int[]{2,3,2}));
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}
