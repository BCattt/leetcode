package com.bcat.algorithms.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution for leetcode 228 - Summary Ranges.
 */
public class SummaryRangesSol {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length <= 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        int num = nums[0];
        int plus = 1;
        int sz = nums.length;
        for (int i = 1; i < sz; ++i) {
            int target = num + plus;
            if (target == nums[i]) {
                ++plus;
            } else {
                if (plus == 1) {
                    result.add(num + "");
                } else {
                    result.add(num + "->" + (num + plus - 1));
                }
                num = nums[i];
                plus = 1;

            }
        }
        if (plus == 1) {
            result.add(num + "");
        } else {
            result.add(num + "->" + (num + plus - 1));
        }

        return result;
    }

    public static void main(String[] args) {
        SummaryRangesSol sol = new SummaryRangesSol();
        int[] nums;

        nums = new int[]{0,1,2,4,5,7};
        System.out.println(sol.summaryRanges(nums));

        nums = new int[]{0,2,3,4,6,8,9};
        System.out.println(sol.summaryRanges(nums));

        nums = new int[]{-1};
        System.out.println(sol.summaryRanges(nums));
    }
}
