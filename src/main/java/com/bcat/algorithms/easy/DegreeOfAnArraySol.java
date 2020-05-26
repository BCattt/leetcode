package com.bcat.algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for LeetCode algorithms 697-Degree of an Array.
 *
 * <p>Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * </p>
 * <p><b>Example 1:</b><pre>
 *     <b>Input: </b>[1, 2, 2, 3, 1]
 *     <b>Output: </b>2
 *     <b>Explanation: </b>
 *     The input array has a degree of 2 because both element 1 and 2 appear twice.
 *     Of the subarrays, that have the same degree:
 *     [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 *     The shortest length is 2. So return 2.
 * </pre></p>
 * <p><b>Example 2:</b><pre>
 *     <b>Input: </b>[1,2,2,3,1,4,2]
 *     <b>Output: </b>6
 * </pre></p>
 * <p><b>Note: </b><ul>
 * <li>{@code nums.length} will be between {@code 1} and {@code 50,000}.</li>
 * <li>{@code nums[i]} will be an integer between {@code 0} and {@code 49,999}.</li>
 * </ul>
 * </p>
 * <p><b>Solution:</b>
 * <p><b>解法1: </b>遍历一遍数组, 将每个数字出现的次数、首次出现位置、最后出现次数记录下来,
 * 同时, 计算最短保持数组度的长度. 一次遍历后, 即可计算出所需长度.</p>
 * </p>
 * @@author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class DegreeOfAnArraySol {
    public static class Node {
        public int count;
        public final int firstIndex;
        public int lastIndex;
        public Node(int count, int firstIndex, int lastIndex) {
            this.count = count;
            this.firstIndex = firstIndex;
            this.lastIndex = lastIndex;

        }

        public Node add(int index) {
            ++count;
            this.lastIndex = index;
            return this;
        }
    }
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Node> count = new HashMap<>();
        int degree = 0;
        Node times;

        for (int i = 0; i < nums.length; ++i) {
            final int idx = i;
            if (degree <= (times = count.compute(nums[i], (k, v) -> null == v ? new Node(1, idx, idx) : v.add(idx))).count) {
                degree = times.count;
            }
        }
        // 计算最小子数组
        int shortest = Integer.MAX_VALUE;
        for (Node node : count.values()) {
            if (node.count == degree) {
                int len = node.lastIndex - node.firstIndex + 1;
                if (len < shortest) {
                    shortest = len;
                }
            }
        }
        return shortest;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1}));
        System.out.println(findShortestSubArray(new int[]{2,1}));
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1}));
        System.out.println(findShortestSubArray(new int[]{2,3,2,3,1,1}));
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
    }
}
