package com.bcat.algorithms.medium;

import java.util.*;

/**
 * Solution for leetcode 554 - Brick Wall.
 */
public class BrickWallSol {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> posNoWallCount = new HashMap<>();
        int n = wall.size();
        int leftMost = 0;
        for (List<Integer> walls : wall) {
            int pos = 0;
            for (Integer w : walls) {
                pos += w;
                ++pos;
                posNoWallCount.compute(pos, (k, v) -> v == null ? 1 : v + 1);
                if (pos > leftMost) {
                    leftMost = pos;
                }
            }
        }
        if (posNoWallCount.get(leftMost) == n) {
            posNoWallCount.remove(leftMost);
        }

        return n - posNoWallCount.values().stream().mapToInt(Integer::valueOf).max().orElse(0);
    }

    public int leastBricks2(List<List<Integer>> wall) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (List<Integer> widths : wall) {
            int n = widths.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += widths.get(i);
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            maxCnt = Math.max(maxCnt, entry.getValue());
        }
        return wall.size() - maxCnt;
    }

    public static void main(String[] args) {
        BrickWallSol sol = new BrickWallSol();
        List<List<Integer>> wall;

        wall = new ArrayList<>(6);
        wall.add(Arrays.asList(1,2,2,1));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,2));
        wall.add(Arrays.asList(2,4));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,1,1));
        System.out.println(sol.leastBricks(wall) + ", " + sol.leastBricks2(wall));

        wall = new ArrayList<>(3);
        wall.add(Arrays.asList(1));
        wall.add(Arrays.asList(1));
        wall.add(Arrays.asList(1));
        System.out.println(sol.leastBricks(wall) + ", " + sol.leastBricks2(wall));

        wall = new ArrayList<>(3);
        wall.add(Arrays.asList(1, 2));
        wall.add(Arrays.asList(1, 2));
        wall.add(Arrays.asList(1, 2));
        System.out.println(sol.leastBricks(wall) + ", " + sol.leastBricks2(wall));

        wall = new ArrayList<>(3);
        wall.add(Arrays.asList(100000000));
        wall.add(Arrays.asList(100000000));
        wall.add(Arrays.asList(100000000));
        System.out.println(sol.leastBricks(wall) + ", " + sol.leastBricks2(wall));

        wall = new ArrayList<>(3);
        wall.add(Arrays.asList(4,5,1));
        wall.add(Arrays.asList(2,1,2,5));
        wall.add(Arrays.asList(1,2,1,2,4));
        System.out.println(sol.leastBricks(wall) + ", " + sol.leastBricks2(wall));
    }
}
