package com.bcat.algorithms.medium;

import com.bcat.utils.Utils;

/**
 * Solution for LeetCode 34 - Find First and Last Position of Element in Sorted Array.
 *
 * <p>Given an array of integers {@code nums} sorted in ascending order, find the
 * starting and ending position of a given {@code target} value.</p>
 * <p>Your algorithm's runtime complexity must be in the order of O(logn). If the
 * target is not found in the array, return [-1, -1].</p>
 * <p><b>Example 1: </b><pre>
 *     <b>Input: </b>nums = [5, 7, 7, 8, 8, 10], target = 8
 *     <b>Output: </b>[3,4]
 * </pre></p>
 * <p><b>Example 2: </b><pre>
 *     <b>Input: </b>nums = [5, 7, 7, 8, 8, 10], target = 6
 *     <b>Output: </b>[-1,-1]
 * </pre></p>
 * <p><b>Solution: </b>
 * <p>二分查找<pre>
 *     第一次出现位置即数组下标最小的位置; 第二次出现位置即数组下标最大位置. 可以通过二分
 * 查找找到所有出现的位置, 然后更新最小下标和最大下标即可.
 * </pre></p>
 * </p>
 */
public class FindFirstAndLastPositionOfElementInSortedArraySol {
    public static int[] searchRange(int[] nums, int target) {
        return bSearch(nums, target, 0, nums.length - 1);
    }

    static int[] bSearch(int[] nums, int target, int start, int end) {
        // 下标相遇, 搜索结束
        if (start >= end) {
            if (start < 0 || end >= nums.length || end < 0) {
                return new int[]{-1, -1};
            }
            if (target == nums[start]) {
                return new int[]{start, start};
            }
            return new int[]{-1, -1};
        }
        // 计算查找位置
        int pos = (start + end) / 2;
        int[] result;
        // 当前位置即目标, 则查看左边和右边是否仍然有数据
        if (target > nums[pos]) {
            // 目标在右侧
            result = bSearch(nums, target, pos + 1, end);
        } else if (target < nums[pos]) {
            // 目标在左侧
            result = bSearch(nums, target, start, pos - 1);
        } else {
            result = new int[]{pos, pos};
            // 与目标相等, 则需要在左侧和右侧继续搜索
            int[] leftMost = bSearch(nums, target, start, pos - 1);
            int[] rightMost = bSearch(nums, target, pos + 1, end);
            // 左边使用最小下标
            result[0] = leftMost[0] == -1 ? leftMost[1] == -1 ? pos : leftMost[1] : leftMost[0];
            // 右边使用最大下标
            result[1] = rightMost[1] == -1 ? rightMost[0] == -1 ? pos : rightMost[0] : rightMost[1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[0];
        int target = 0;
        System.out.println(Utils.intArray2String(nums) + ", target[" + target + "] = " + Utils.intArray2String(searchRange(nums, target)));

        nums = new int[]{1};
        target = 1;
        System.out.println(Utils.intArray2String(nums) + ", target[" + target + "] = " + Utils.intArray2String(searchRange(nums, target)));
        target = 2;
        System.out.println(Utils.intArray2String(nums) + ", target[" + target + "] = " + Utils.intArray2String(searchRange(nums, target)));

        nums = new int[]{5,5};
        target = 5;
        System.out.println(Utils.intArray2String(nums) + ", target[" + target + "] = " + Utils.intArray2String(searchRange(nums, target)));
        target = 1;
        System.out.println(Utils.intArray2String(nums) + ", target[" + target + "] = " + Utils.intArray2String(searchRange(nums, target)));

        nums = new int[]{5,7,7,8,8,10};
        target = 8;
        System.out.println(Utils.intArray2String(nums) + ", target[" + target + "] = " + Utils.intArray2String(searchRange(nums, target)));
        target = 6;
        System.out.println(Utils.intArray2String(nums) + ", target[" + target + "] = " + Utils.intArray2String(searchRange(nums, target)));


    }
}
