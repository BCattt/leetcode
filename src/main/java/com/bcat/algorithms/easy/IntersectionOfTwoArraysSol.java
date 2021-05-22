package com.bcat.algorithms.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Solution for leetcode 349 - Intersection of Two Arrays.
 */
public class IntersectionOfTwoArraysSol {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> intersect = new HashSet<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            int n1 = nums1[i];
            int n2 = nums2[j];
            if (n1 == n2) {
                intersect.add(n1);
                ++i;
                ++j;
            } else if (n1 < n2) {
                ++i;
            } else {
                ++j;
            }
        }
        return intersect.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysSol sol = new IntersectionOfTwoArraysSol();

        int[] nums1;
        int[] nums2;

        nums1 = new int[]{1,2,2,1};
        nums2 = new int[]{2,2};
        System.out.println(Arrays.toString(sol.intersection(nums1, nums2)));

        nums1 = new int[]{4,9,5};
        nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(sol.intersection(nums1, nums2)));
    }
}

