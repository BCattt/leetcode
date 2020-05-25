package com.bcat.algorithms.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution for LeetCode algorithms 198 - House Robber.
 *
 * <p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping
 * you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each
 * house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * </p>
 * <p>
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * </p>
 * <p><pre>
 * <b>Example 2:</b>
 *
 * <b>Input:</b> [2,7,9,3,1]
 * <b>Output:</b> 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 * </pre>
 * </p>
 *
 * <p><b>Solution: </b>
 * <p>1. 按照房屋金额进行排序并记录房间号, 然后从大到小偷窃, 相邻已偷过的跳过.</p>
 * </p>
 */
public class HouseRobberSol {
    public static class Money {
        public final int money;
        public final int index;

        public Money(int money, int index) {
            this.money = money;
            this.index = index;
        }
    }
    public static int rob(int[] nums) {
        // 记录房屋是否被访问过
        boolean[] visited = new boolean[nums.length + 2];
        // 对房屋中的金额进行排序, 并记录房间编号
        List<Money> monies = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            // index增加1, 下标从1开始, 避免过界检测
            monies.add(new Money(nums[i], i + 1));
        }
        // 从大到小排序
        monies.sort((m1, m2) -> (m2.money - m1.money));
        // 开始偷窃
        int result = 0;
        for (int i = 0; i < monies.size(); ++i) {
            Money money = monies.get(i);
            // 左边房屋及右边房屋有没有被偷窃
            if (visited[money.index - 1] || visited[money.index + 1]) {
                continue;
            } else {
                result += money.money;
                visited[money.index] = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

}
