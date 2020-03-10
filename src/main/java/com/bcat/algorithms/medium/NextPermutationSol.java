package com.bcat.algorithms.medium;

import com.bcat.utils.Utils;

/**
 * Solution for LeetCode Algorithm problem 31-Next Permutation.
 *
 * <p>Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * {@code
 *   1,2,3 → 1,3,2
 *   3,2,1 → 1,2,3
 *   1,1,5 → 1,5,1
 * }
 *
 * 解题思路:
 * 对于长度为n的数组:
 * 从尾部开始查找, 直到查找到错误的序列, 即nums[i] < nums[i+1].
 * 那么, 直接将nums[i]与nums[i+2] ... nums[n-1]中大于nums[i]的最小数交换,
 * 然后将nums[i+1]中的数排序即可(由于基本有序, 从头到尾交换即可).
 * 而如果i + 1 == n-1, 则直接交换即可;
 * 如果i == 0, 则从头开始交换.
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class NextPermutationSol {
    public static void nextPermutation(int[] nums) {
        int tmp = 0;
        // 查找不符合升序的元素
        int idx = nums.length - 1;
        while (idx > 0 && nums[idx-1] >= nums[idx]) --idx;
        // 如果idx == 0, 则从头开始交换即可
        int swapStart = 0, swapEnd = nums.length - 1;
        if (idx == 0) {
            swapStart = 0;
            // 如果idx == nums.length - 1, 则只交换最后两个数字
        } else if (idx == nums.length - 1) {
            swapStart = idx - 1;
        } else {
            boolean found = false;
            // 从idx ... nums.length - 1中查找大于nums[idx - 1]的数字并交换
            for (int i = nums.length - 1; i > idx; --i) {
                if (nums[i] > nums[idx - 1]) {
                    tmp = nums[i];
                    nums[i] = nums[idx - 1];
                    nums[idx - 1] = tmp;
                    found = true;
                    break;
                }
            }
            // 如果未找到, 则直接交换idx - 1 和 idx
            if (!found) {
                tmp = nums[idx];
                nums[idx] = nums[idx - 1];
                nums[idx - 1] = tmp;
            }
            // 从idx 到 nums.length - 1开始交换
            swapStart = idx;
        }
        // 两两交换
        for (int i = swapStart, j = swapEnd; i < j; ++i, --j) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        String oriArray = Utils.intArray2String(nums);
        nextPermutation(nums);
        System.out.println(oriArray + " -> " + Utils.intArray2String(nums));

        nums = new int[]{3,2,1};
        oriArray = Utils.intArray2String(nums);
        nextPermutation(nums);
        System.out.println(oriArray + " -> " + Utils.intArray2String(nums));

        nums = new int[]{1,3,2};
        oriArray = Utils.intArray2String(nums);
        nextPermutation(nums);
        System.out.println(oriArray + " -> " + Utils.intArray2String(nums));

        nums = new int[]{2,3,1};
        oriArray = Utils.intArray2String(nums);
        nextPermutation(nums);
        System.out.println(oriArray + " -> " + Utils.intArray2String(nums));

        nums = new int[]{1,1,5};
        oriArray = Utils.intArray2String(nums);
        nextPermutation(nums);
        System.out.println(oriArray + " -> " + Utils.intArray2String(nums));

        nums = new int[]{5,1,1};
        oriArray = Utils.intArray2String(nums);
        nextPermutation(nums);
        System.out.println(oriArray + " -> " + Utils.intArray2String(nums));

        nums = new int[]{4,3,2,1};
        oriArray = Utils.intArray2String(nums);
        nextPermutation(nums);
        System.out.println(oriArray + " -> " + Utils.intArray2String(nums));

        nums = new int[]{2,2,7,5,4,3,2,2,1};
        oriArray = Utils.intArray2String(nums);
        nextPermutation(nums);
        System.out.println(oriArray + " -> " + Utils.intArray2String(nums));
    }
}
