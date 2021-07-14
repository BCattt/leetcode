package com.bcat.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for leetcode 1863 - Sum of All Subset XOR Totals.
 */
public class SumOfAllSubsetXorTotalsSol {
    public int subsetXORSum(int[] nums) {
        int xor = 0; // empty subset
        List<List<Integer>> results = new ArrayList<>();
        subset(nums, 0, results);
        return 0;
    }

    private void subset(int[] nums, int i, List<List<Integer>> results) {
        if (i == 0) {
            for (int s = i; s < nums.length; ++s) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[s]);
                results.add(result);
            }
        } else {
            for (int s = i; s < nums.length; ++s) {
                int sz = results.size();
                for (int j = 0; j < sz; ++j) {
                    List<Integer> tR = new ArrayList<>(results.get(j));
                    tR.add(nums[s]);
                    results.add(tR);
                    subset(nums, s + 1, results);
                }
            }
        }
    }

    public static void main(String[] args) {
        SumOfAllSubsetXorTotalsSol sol = new SumOfAllSubsetXorTotalsSol();
        sol.subsetXORSum(new int[]{1, 3});
    }
}
