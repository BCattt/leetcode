package com.bcat.algorithms.easy;

/**
 * Solution for LeetCode problem 121 - Best Time to Buy and Sell Stock.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * @author <a href="zjebusiness@gmail.com">赵峻</a>
 */
public class BestTimeToBuyAndSellStockSol {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 按时间序列寻找两个差最大值
        // 只需要记录当前已读序列的最小值, 读一个数, 则减去这个最小值, 看是否大于当前差值
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            // 小于当前最小价格，替换当前最小价格
            if (prices[i] < min) {
                min = prices[i];
                // 是否大于当前最大利润, 大于则替换当前最大利润
            } else if (prices[i] - min > maxProfit){
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
