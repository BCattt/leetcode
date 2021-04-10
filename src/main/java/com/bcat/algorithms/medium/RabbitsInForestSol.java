package com.bcat.algorithms.medium;

/**
 * Solution for leetcode 781 - Rabbits in Forest.
 */
public class RabbitsInForestSol {
    public int numRabbits(int[] answers) {
        short[] samePcs = new short[1000];
        int answer = 0;
        for (int sameColorRabbits : answers) {
            if (samePcs[sameColorRabbits] == 0) {
                answer += sameColorRabbits + 1;
                samePcs[sameColorRabbits] += 1;
            } else if (samePcs[sameColorRabbits] <= sameColorRabbits) {
                samePcs[sameColorRabbits] += 1;
            } else {
                answer += sameColorRabbits + 1;
                samePcs[sameColorRabbits] = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        RabbitsInForestSol sol = new RabbitsInForestSol();
        System.out.println(sol.numRabbits(new int[]{0}));
        System.out.println(sol.numRabbits(new int[]{1, 1, 2}));
        System.out.println(sol.numRabbits(new int[]{10, 10, 10}));
        System.out.println(sol.numRabbits(new int[]{0, 0, 1, 1, 1}));
        System.out.println(sol.numRabbits(new int[]{1, 0, 1, 0, 0}));
        System.out.println(sol.numRabbits(new int[]{}));
    }
}
