package com.bcat.easy;

import java.util.Hashtable;

/**
 * Solution for LeetCode Problem 1.Two Sum
 *
 * <p><b>Problem description: </b>
 *    Given an array of integers, return <b>indices</b> of the two numbers such that they add up to a specific
 * target. You may assume that each input would have exactly one solution, and you may not use the <i>same</i>
 * element twice.
 * </p>
 * <p>
 *   <b>Problem solving: </b>
 *   有两种解题思路：
 *   1. 暴力破解法:
 *   2. 一遍哈希法：
 *       构造一个以数值作为{@code key}，以下标作为{@code value}的哈希表。一次遍历数组，从哈希表中查找{@code target - nums[i]}的值，
 *   找到则是对应答案；否则，将当前数值{@code nums[i]}存入哈希表并继续遍历。
 * </p>
 */
public class TwoSumSol {
    public static int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> valueKeyMap = new Hashtable<>(nums.length);
        Integer idx;
        for (int i = 0; i < nums.length; ++i) {
            if ((idx = valueKeyMap.get(target - nums[i])) != null) {
                return new int[]{i, idx};
            }
            valueKeyMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums, target));
    }
}
