package com.bcat.algorithms.easy;

import com.bcat.utils.Utils;

/**
 * Solution for leetcode 88 - Merge Sorted Array.
 */
public class MergeSortedArraySol {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int aSz = m;
        while (i < aSz && j < n) {
            while (i < aSz && nums1[i] <= nums2[j]) {
                ++i;
            }
            int oriJ = j;
            while (j < n && nums1[i] > nums2[j]) {
                ++j;
            }
            int sz = j - oriJ;
            System.arraycopy(nums1, i, nums1, i + sz, aSz - i);
            System.arraycopy(nums2, oriJ, nums1, i, sz);
            aSz += sz;
            i = i + sz;
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, m + j, n - j);
        }
    }

    public static void main(String[] args) {
        MergeSortedArraySol sol = new MergeSortedArraySol();
        int[] nums1;
        int[] nums2;
        int m, n;
        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        nums2 = new int[]{2, 5, 6};
        m = 3;
        n = 3;
        sol.merge(nums1, m, nums2, n);
        System.out.println(Utils.intArray2String(nums1));

        nums1 = new int[]{1, 2, 8, 0, 0, 0};
        nums2 = new int[]{2, 5, 6};
        m = 3;
        n = 3;
        sol.merge(nums1, m, nums2, n);
        System.out.println(Utils.intArray2String(nums1));

        nums1 = new int[]{1};
        nums2 = new int[]{};
        m = 1;
        n = 0;
        sol.merge(nums1, m, nums2, n);
        System.out.println(Utils.intArray2String(nums1));

        nums1 = new int[]{0};
        nums2 = new int[]{5};
        m = 0;
        n = 1;
        sol.merge(nums1, m, nums2, n);
        System.out.println(Utils.intArray2String(nums1));

        nums1 = new int[]{1, 2, 3, 0, 0, 0, 0};
        nums2 = new int[]{-1, 5, 6, 8};
        m = 3;
        n = 4;
        sol.merge(nums1, m, nums2, n);
        System.out.println(Utils.intArray2String(nums1));

        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        nums2 = new int[]{5, 6, 8};
        m = 3;
        n = 3;
        sol.merge(nums1, m, nums2, n);
        System.out.println(Utils.intArray2String(nums1));

        nums1 = new int[]{5, 6, 8, 0, 0, 0};
        nums2 = new int[]{1, 2, 3};
        m = 3;
        n = 3;
        sol.merge(nums1, m, nums2, n);
        System.out.println(Utils.intArray2String(nums1));

        nums1 = new int[]{0,0,3,0,0,0,0,0,0};
        m = 3;
        nums2 = new int[]{-1,1,1,1,2,3};
        n = 6;
        sol.merge(nums1, m, nums2, n);
        System.out.println(Utils.intArray2String(nums1));
    }
}
