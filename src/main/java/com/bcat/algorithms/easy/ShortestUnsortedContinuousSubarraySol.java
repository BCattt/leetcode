package com.bcat.algorithms.easy;

import com.bcat.utils.Utils;

/**
 * Solution for LeetCode algorithm 581 - Shortest Unsorted Continuous Subarray.
 *
 * <p>Given an integer array, you need to find on <b>continuous subarray</b> that
 * if you only sort this subarray in ascending order, then the whole array will
 * be sorted in ascending order, too.</p>
 * <p>You need to find the <b>shortest</b> such subarray and output its length.</p>
 * <p><b>Example 1:</b><pre>
 *     <b>Input: </b>[2, 6, 4, 8, 10, 9, 15]
 *     <b>Output: </b>5
 *     <b>Explanation: </b>You need to sort [6, 4, 8, 10, 9] in ascending order
 *                  to make the whole array sorted in ascending order.
 * </pre></p>
 * <p><b>Note: </b><ol>
 *     <li>The length of the input array is in range[1, 10,000].</li>
 *     <li>The input array may contain duplicates, so ascending order here means
 *     {@code <=}.</li>
 * </ol></p>
 * <p><b>Solution: </b>
 * <p><b>1. 回溯</b><pre>
 *     假设此最小连续乱序子数组位置数组中间, ai ... aj, 则此子数组需要满足以下条件:
 * 1) a1 ... ai-1是升序
 * 2) ai-1 <= min(ai ... aj)
 * 3) aj+1 >= max(ai ... aj)
 * 4) aj+1 ... an是升序
 * 可以这么做:
 *     遍历数组, 找到a1 ... ai-1的升序子数组, 继续遍历, 找到ai ... aj, 并在遍历过程中
 * 统计ai ... aj的最小、最大值; 如果不满足条件2), 则从i - 1向前移动下标, 直到0; 如果不
 * 满足条件3), 则从j + 1开始向后移动下标, 直到n - 1.
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * </pre></p>
 * </p>
 */
public class ShortestUnsortedContinuousSubarraySol {
    public static int findUnsortedSubarray(int[] nums) {
        // 升序数组最大值索引
        int ascendingMaxIdx = 0;
        // 升序数组最小值索引
        int ascendingMinIdx = nums.length - 1;
        // 乱序中的最小、最大值
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // 搜索左边的升序序列
        int i = 1;
        while (i < nums.length && nums[i] >= nums[i - 1]) {
            ascendingMaxIdx = i++;
        }
        // 从数组尾部向前搜索降序序列
        i = nums.length - 1;
        while (i > 0 && nums[i] >= nums[i - 1]) {
            ascendingMinIdx = --i;
        }
        // 统计乱序序列中的最大、最小值并调整左侧升序序列和右侧升序序列的索引位置
        for (i = ascendingMaxIdx; i <= ascendingMinIdx; ++i) {
            if (nums[i] <= min) {
                min = nums[i];
            }
            if (nums[i] >= max) {
                max = nums[i];
            }
        }
        // 根据乱序序列的最小、最大值调整左、右的索引位置
        while (ascendingMaxIdx > 0 && min < nums[ascendingMaxIdx]) {
            --ascendingMaxIdx;
        }
        while (ascendingMinIdx < nums.length - 1 && max > nums[ascendingMinIdx]) {
            if (nums[ascendingMinIdx] <= min) {
                min = nums[ascendingMinIdx];
            }
            ++ascendingMinIdx;

        }
        // 进行一次修正, 如果最小值小于nums[ascendingMaxIdx], 则表示此数也需要重新排序
        // 相应地, 如果最大值大于nums[ascendingMinIdx], 则表示此数也需要重新排序
        if (ascendingMaxIdx < ascendingMinIdx) {
            if (min >= nums[ascendingMaxIdx]) {
                ++ascendingMaxIdx;
            }
            if (max <= nums[ascendingMinIdx]) {
                --ascendingMinIdx;
            }
            return ascendingMinIdx - ascendingMaxIdx + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2}; // 0
        System.out.println(Utils.intArray2String(nums) + " = " + findUnsortedSubarray(nums));

        nums = new int[]{2, 3};    // 0
        System.out.println(Utils.intArray2String(nums) + " = " + findUnsortedSubarray(nums));

        nums = new int[]{2, 3, 4}; // 0
        System.out.println(Utils.intArray2String(nums) + " = " + findUnsortedSubarray(nums));

        nums = new int[]{4, 3, 2}; // 3
        System.out.println(Utils.intArray2String(nums) + " = " + findUnsortedSubarray(nums));

        nums = new int[]{1, 3, 2, 3, 3};  // 2
        System.out.println(Utils.intArray2String(nums) + " = " + findUnsortedSubarray(nums));

        nums = new int[]{3, 4, 5, 6, 7, 2}; // 6
        System.out.println(Utils.intArray2String(nums) + " = " + findUnsortedSubarray(nums));

        nums = new int[]{8, 3, 4, 5, 6, 7, 9}; // 6
        System.out.println(Utils.intArray2String(nums) + " = " + findUnsortedSubarray(nums));

        nums = new int[]{2, 6, 4, 8, 10, 9, 15}; // 5
        System.out.println(Utils.intArray2String(nums) + " = " + findUnsortedSubarray(nums));
    }
}
