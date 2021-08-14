package com.bcat.algorithms.medium;

import java.util.*;

public class RestoreTheArrayFromAdjacentPairsSol {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Set<Integer>> adjacents = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        for (int[] adjacent : adjacentPairs) {
            adjacents.compute(adjacent[0], (k, v) -> v == null ? new HashSet<>(2) : v).add(adjacent[1]);
            adjacents.compute(adjacent[1], (k, v) -> v == null ? new HashSet<>(2) : v).add(adjacent[0]);
            counts.compute(adjacent[0], (k, v) -> v == null ? 1 : v + 1);
            counts.compute(adjacent[1], (k, v) -> v == null ? 1 : v + 1);
        }
        int start = counts.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).findFirst().get();
        int n = adjacentPairs.length + 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = start;
            Set<Integer> adjacentNodes = adjacents.get(start);
            for (int adjacentNode : adjacentNodes) {
                adjacents.get(adjacentNode).remove(start);
                start = adjacentNode;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RestoreTheArrayFromAdjacentPairsSol sol = new RestoreTheArrayFromAdjacentPairsSol();
        int[][] adjacentPairs;

        adjacentPairs = new int[][]{
                {4, -2}, {1,4}, {-3,1}
        };
        System.out.println(Arrays.toString(sol.restoreArray(adjacentPairs)));
    }
}
