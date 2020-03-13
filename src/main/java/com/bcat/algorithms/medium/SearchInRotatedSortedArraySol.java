package com.bcat.algorithms.medium;

/**
 * Solution for LeetCode Algorithm problem 33-Search in Rotated Sorted Array.
 *
 * <p>Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *    (i.e., {@code [0,1,2,4,5,6,7]} might become {@code [4,5,6,7,0,1,2]}).
 *  You are given a target value to search. If found in the array return its index, otherwise return {@code -1}.
 *  You may assume no duplicate exists in the array.
 *  Your algorithm's runtime complexity must be in the order of {@code O(log n)}.
 *
 * <p><b>Example 1:</b>
 * {@code
 *   Input: nums = [4,5,6,7,0,1,2], target = 0
 *   Output: 4
 * }
 * <p><b>Example 2: </b>
 * {@code
 *   Input: nums = [4,5,6,7,0,1,2], target = 3
 *   Output: -1
 * }
 *
 * <p>解题思路:
 * 仍然需要使用二分查找.
 * 有序数组在某个位置被旋转后, 数组首尾相连, 则仍然是一个有序数组. 这样, 当我们进行二分
 * 查找时, 如果发现某个位置的值不再满足查找条件, 则跳到另一半进行查找. 举例如下
 * 4,5,6,7,0,1,2中查找0,
 * 第一趟7为哨兵, 7 > 0, 我们在左边查找;
 * 第二趟5为哨兵, 5 > 0, 我们在4,5之间查找;
 * 第三趟4为哨兵, 4 > 0, 但4已经是第一个元素, 则跳到 0,1,2中查找
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class SearchInRotatedSortedArraySol {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return find(nums, 0, nums.length - 1, target);
    }

    static int find(int[] nums, int startIdx, int endIdx, int target) {
        if (startIdx < 0 || endIdx < 0) {
            return -1;
        }
        // 上下界相遇, 查找结束
        if (startIdx == endIdx) {
            if (nums[startIdx] == target) {
                return startIdx;
            } else {
                return -1;
            }
        }
        int sentinel = (startIdx + endIdx) / 2;

        if (nums[sentinel] > target) {
            // 如果左边未找到, 则在右边搜索
            int leftIdx = find(nums, startIdx, sentinel - 1, target);
            if (-1 == leftIdx && sentinel + 1 <= endIdx) {
                return find(nums, sentinel + 1, endIdx, target);
            } else {
                return leftIdx;
            }
        } else if (nums[sentinel] == target) {
            return sentinel;
        } else {
            // 如果右边未找到, 则在左边搜索
            int rightIdx = find(nums, sentinel + 1, endIdx, target);
            if (-1 == rightIdx && sentinel - 1 >= startIdx) {
                return find(nums, startIdx, sentinel - 1, target);
            } else {
                return rightIdx;
            }
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(search(new int[]{0,1,2,4,5,6,7}, 4));
        System.out.println(search(new int[]{7,0,1,2,4,5,6}, 4));
        System.out.println(search(new int[]{7,0,1,2,4,5,6}, 7));
        System.out.println(search(new int[]{7,0,1,2,4,5,6}, 6));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 4));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 8));
        System.out.println(search(new int[]{}, 5));
        System.out.println(search(new int[]{1,3}, 0));
        System.out.println(search(new int[]{4,5,6,7,8,1,2,3}, 8));
        long end = System.nanoTime();
        System.out.println("Time elapsed : " + (end - start) / 1_000 + "us");
    }
}

