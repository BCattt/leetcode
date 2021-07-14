package com.bcat.algorithms.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Solution for leetcode 274 - H-Index.
 */
public class HIndexSol {
    public int hIndex(int[] citations) {
        int sz = citations.length;
        Arrays.sort(citations);
        TreeMap<Integer, Integer> citationMap = new TreeMap<>();
        for (int i = 0; i < sz; ++i) {
            final int count = sz - i;
            citationMap.compute(citations[i], (k, v) -> v == null ? count : v);
        }
        for (int i = citations[sz - 1]; i > 0; --i) {
            if (citationMap.containsKey(i)) {
                if (citationMap.get(i) >= i) {
                    return i;
                }
            } else {
                Map.Entry<Integer, Integer> ceiling = citationMap.ceilingEntry(i);
                if (ceiling.getValue() >= i) {
                    return i;
                }
            }
        }
        Arrays.fill
        return 0;
    }

    public static void main(String[] args) {
        HIndexSol sol = new HIndexSol();
        int[] citations;
        citations = new int[]{3,0,6,1,5};
        System.out.println(sol.hIndex(citations));

        citations = new int[]{1,3,1};
        System.out.println(sol.hIndex(citations));

        citations = new int[]{100};
        System.out.println(sol.hIndex(citations));

        citations = new int[]{1,2,2};
        System.out.println(sol.hIndex(citations));
    }
}
