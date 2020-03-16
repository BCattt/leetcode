package com.bcat.interview.lcci.easy;

/**
 * Solution for LeetCode 面试题10.01. Sorted Merge LCCI
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order.
 *
 * Initially the number of elements in A and B are m and n respectively.
 *
 * Example:
 *
 * Input:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class SortedMergeSol {
    public static void merge(int[] A, int m, int[] B, int n) {
        if (n == 0) {
            return;
        }
        int[] result = new int[m + n];
        for (int i = 0, j = 0, k = 0; k < result.length; ++k) {
            // 处理边界情况
            if (i < m && j < n) {
                if (A[i] > B[j]) {
                    result[k] = B[j];
                    ++j;
                } else {
                    result[k] = A[i];
                    ++i;
                }
            } else if (i < m){
                result[k] = A[i];
                ++i;
            } else {
                result[k] = B[j];
                ++j;
            }
        }
        for (int i = 0; i < result.length; ++i) {
            A[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        merge(A, 3, B, 3);
        for (int i = 0; i < A.length; ++i) {
            System.out.print(A[i] + ", ");
        }
        System.out.println();
        A = new int[]{2, 0};
        B = new int[]{1};
        merge(A, 1, B, 1);
        for (int i = 0; i < A.length; ++i) {
            System.out.print(A[i] + ", ");
        }
    }
}
