package com.bcat.interview.easy;

import java.util.Arrays;

import com.bcat.utils.Utils;

/**
 * Solution for LeetCode interview problem 40-least k numbers.
 * <p>输入整数数组{@literal arr}, 找出其中最小的{@literal k}个数。例如，输入
 * 4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4</p>
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class LeastKNumsSol {
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

    public static void main(String[] args) {
        Utils.printIntArray(getLeastNumbers(new int[]{3,2,1}, 2));
    }
}
