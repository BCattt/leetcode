package com.bcat.algorithms.medium;

/**
 * Solution for LeetCode algirhtm problem 300-Longest Increasing Subsequence.
 * <p>Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p><b>Example: </b>
 * {@code
 *   Input: [10,9,2,5,3,7,101,18]
 *   Output: 4
 *   Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * }
 *
 * <p><b>Note: </b>
 * <ul>
 *     <li>There may be more than one LIS combination, it is only necessary for you to return the length.</li>
 *     <li>Your algorithm should run in {@code O(n^2)} complexity.</li>
 * </ul>
 * <p><b>Follow up: </b>Could you improve it to {@code O(n log n)} time complexity?</p>
 *
 * <p>解题思路:
 * <p>思路1: 动态规算法(复杂度为O(n^2)算法):
 *    使用dp表记录当前每个数的最长升序子序列, 对于第0个元素, 其最长升序子序列为1;
 *    对于第2个元素, 如果 nums[1] > nums[0], 则其最长升序子序列长度为2, 否则为1
 *    同理, 对于第n个元素, 其最长升序子序列为0 ~ n-1元素中小于nums[n]的元素最长
 *    升序子序列长度 + 1, 我们只需要找出0 ~ n-1元素中小于nums[n]且长度最大那个序列长度即可.
 * </p>
 * </p>
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class LongestIncreasingSubsequenceSol {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 记录截止到nums[i]数的最长子序列长度
        int[] dp = new int[nums.length];
        // 第一个数的最长升序子序列长度为1
        dp[0] = 1;
        int maxans = 1;
        // 从第二个数开始
        for (int i = 1; i < dp.length; i++) {
            // 当前子序列nums[0] ... nums[i-1]之间的最大值
            int maxval = 0;
            // 测试当前数nums[i]前的所有数
            for (int j = 0; j < i; j++) {
                // 如果当前数nums[i] > 其之前的某个数nums[j], 则其最大升序子序列与
                // 当前最大值对比
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            // 在上一个 i - 1最长升序子序列基础上+1
            dp[i] = maxval + 1;
            // 计算当前最长升序子序列长度
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
