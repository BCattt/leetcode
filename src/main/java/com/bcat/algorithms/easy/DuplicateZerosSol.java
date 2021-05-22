package com.bcat.algorithms.easy;

import java.util.Arrays;

/**
 * Solution for leetcode 1089 - Duplicate Zeros.
 */
public class DuplicateZerosSol {
    public void duplicateZeros(int[] arr) {
        int sz = arr.length;
        for (int i = 0; i < sz; ++i) {
            if (arr[i] == 0) {
                int dst = i + 2;
                if (dst >= sz) {
                    arr[sz - 1] = 0;
                } else {
                    int len = sz - i - 2;
                    System.arraycopy(arr, i + 1, arr, dst, len);
                    arr[i + 1] = 0;
                }
                ++i;
            }
        }
    }

    public static void main(String[] args) {
        DuplicateZerosSol sol = new DuplicateZerosSol();
        int[] arr;

        arr = new int[]{1,0,2,3,0,4,5,0};
        sol.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));


        arr = new int[]{1,2,3};
        sol.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 1};
        sol.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0};
        sol.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 0};
        sol.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 0, 0};
        sol.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 0, 1};
        sol.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 0, 1, 0, 1};
        // 00010
        // 00001
        sol.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
