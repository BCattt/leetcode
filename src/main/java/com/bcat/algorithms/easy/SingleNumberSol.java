package com.bcat.algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for LeetCode algorithm problem 136-Single Number.
 *
 * <p>Given a <b>non-empty</b> array of integers, every element appears
 * <i>twice</i> except for one. Find the single one.</p>
 * <p><b>Note:</b>
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?</p>
 * <p>
 * <p><b>Example 1:</b>
 * {@literal
 *   Input: [2,2,1]
 *   Output: 1
 * }
 * </p>
 * <p><b>Example 2:</b>
 * {@literal
 *   Input: [4,1,2,1,2]
 *   Output: 4
 * }
 * </p>
 * </p>
 * <p><b>解题思路:</b>
 * <p><b>思路1: </b>
 * 使用一个{@code HashMap}保存数组中每个数字出现的次数, 最后遍历{@code Map}找到值为1的
 * 那个元素. 时间复杂度O(3/2n), 空间复杂度O(n).
 * </p>
 * <p><b>思路2: </b>
 * 不使用额外空间, 
 * </p>
 * </p>
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class SingleNumberSol {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> appearance = new HashMap<>(nums.length / 2 + 1);
        for (int num : nums) {
            appearance.compute(num, (k, v) -> null == v ? 1 : v+1);
        }
        for (Map.Entry<Integer,Integer> entry : appearance.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }
}
