package com.bcat.algorithms.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInStreamSol {
    private final int k;
    private final int[] nums;
    public KthLargestElementInStreamSol(int k, int[] nums) {
        this.k = k;
        this.nums = new int[nums.length];
        System.arraycopy(nums, 0, this.nums, 0, nums.length);
    }

    public int add(int val) {
        return 0;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

    }
}
