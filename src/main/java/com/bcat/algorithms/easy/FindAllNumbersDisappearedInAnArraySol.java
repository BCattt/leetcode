package com.bcat.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

import com.bcat.utils.Utils;

/**
 * Solution for LeetCode 448 - Find All Numbers Disappeared in an Array.
 *
 * <p>Given an array of integers where {@code 1 <= a[i] <= n }({@code n} = size of
 * array), some elements appear twice and others appear once. Find all the
 * elements of [1,n] inclusive that do not appear in this array.
 * Could you do it without extra space and in {@code O(n)} runtime? You may
 * assume the returned list does not count as extra space.</p>
 * <p><b>Example: </b><pre>
 *     <b>Input: </b>[4,3,2,7,8,2,3,1]
 *     <b>Output: </b>[5,6]
 * </pre></p>
 * <p><b>Solution: </b>
 * <p>1. 在数组中统计数字出现的次数. 由于[1..n]的数字存放在长度为n的数组中, 因此其下标即
 * 为i - 1, 遍历数组, 直接将其出现次数统计在其下标下, 统计完成后, 如果对应下标为0, 则表示
 * 其出现次数为0.
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)</p>
 * </p>
 */
public class FindAllNumbersDisappearedInAnArraySol {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        // 出现标记为-1, 未出现标记为0
        for (int i = 0; i < nums.length; ++i) {
            // 已经出现过的数字, 直接跳过
            if (-1 == nums[i]) {
                continue;
            }
            // 将当前数字对应位置的数字置成-1
            int tmp = nums[nums[i] - 1];
            nums[nums[i] - 1] = -1;
            // 继续查找tmp的位置
            while (tmp > 0) {
                int tmp1 = nums[tmp - 1];
                nums[tmp - 1] = -1;
                tmp = tmp1;
            }
            // 当前还未找到, 将其置为0
            if (nums[i] != -1) {
                nums[i] = 0;
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (0 == nums[i]) {
                answer.add(i + 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Utils.list2Str(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1})));
    }
}
