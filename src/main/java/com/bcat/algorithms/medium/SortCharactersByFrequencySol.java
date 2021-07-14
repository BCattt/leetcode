package com.bcat.algorithms.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Solution for leetcode 451 Sort Characters By Frequency
 */
public class SortCharactersByFrequencySol {
    public String frequencySort(String s) {
        char[] sA = s.toCharArray();
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : sA) {
            counts.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        List<Map.Entry<Character, Integer>> sorted = counts.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue()).collect(Collectors.toList());
        StringBuilder result = new StringBuilder(s.length());
        for (Map.Entry<Character, Integer> ch : sorted) {
            for (int i = 0; i < ch.getValue(); ++i) {
                result.append(ch.getKey());
            }
        }
        return result.toString();
    }
}
