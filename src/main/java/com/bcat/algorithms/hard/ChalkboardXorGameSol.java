package com.bcat.algorithms.hard;

/**
 * Solution for leetcode 810 - Chalkboard Xor Game.
 */
public class ChalkboardXorGameSol {
    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0;
    }
}
