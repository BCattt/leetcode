package com.bcat.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution for LeetCode problem 15. 3Sum
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 解题思路：
 * 1. 暴力破解
 *    对数组进行三层循环，在最里面一层循环求和，如果相等，则返回三个数值。由于是逐个遍历，不会出现重复情况。
 */
public class ThreeSumSol {
    /**
     * 暴力破解法
     */
    public static List<List<Integer>> brutalForce(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i; j < nums.length; ++j) {
                for (int k = j; k < nums.length; ++k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        answers.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return answers;
    }
}
