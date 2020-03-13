package com.bcat.algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for LeetCode algorithm problem 169-Majority Element.
 * <p>Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *    You may assume that the array is non-empty and the majority element always exist in the array.
 * <p><b>Example 1: </b>
 * {@code
 *   Input: [3,2,3]
 *   Output: 3
 * }
 * <p><b>Example 2: </b>
 * {@code
 *   Input: [2,2,1,1,1,2,2]
 *   Output: 2
 * }
 * <p>解题思路:
 * <p>思路1:
 * 将每个数统计放到一个Map中, 最后统计Map中每个数的个数即可.
 * <p>思路2:
 * 
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class MajorityElementSol {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> timesMap = new HashMap<>(nums.length / 2 + 1);
        for (int i = 0 ; i < nums.length; ++i) {
            timesMap.compute(nums[i], (k,v) -> null == v ? 1 : ++v);
        }
        int majorityTimes = Double.valueOf(Math.floor(nums.length / 2.0)).intValue();
        int majority = 0;
        for (Map.Entry<Integer, Integer> entry : timesMap.entrySet()) {
            if (entry.getValue() > majorityTimes) {
                majority = entry.getKey();
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        assert 3 == majorityElement(nums);

        nums = new int[]{2,2,1,1,1,1,2,2};
        assert 2 == majorityElement(nums);
    }
}
