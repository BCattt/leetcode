package com.bcat.algorithms.easy;

/**
 * Solution for LeetCode Algorithm problem 1013-Partition Array Into Three Parts With Equal Sum
 * <p>Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
 * Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 *
 * <p><b>Example 1:</b>
 * {@code
 *   Input: A = [0,2,1,-6,6,-7,9,1,2,0,1]
 *   Output: true
 *   Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * }
 * <p><b>Example 2:</b>
 * {@code
 *   Input: A = [0,2,1,-6,6,7,9,-1,2,0,1]
 *   Output: false
 * }
 * <p><b>Example 3:</b>
 * {@code
 *   Input: A = [3,3,6,5,-2,2,5,1,-9,4]
 *   Output: true
 *   Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 * }
 * <p>Constraints:
 * <ul>
 * <li>{@code 3 <= A.length <= 50000 }</li>
 * <li>{@code -10^4 <= A[i] <= 10^4 }</li>
 * </ul>
 *
 * <p>解题思路:
 * 既然将数组分成连续三段, 每段数字的和相等. 那么, 先求数组所有数字的和sumAll, 看能否被3整除,
 * 如果能, 则进一步遍历数组并对每个数字加和, 每得到一个sumAll/3则从下一个数字开始重新加和.
 * 当遍历到第2个sumAll/3且后面仍然有元素时即可停止(后面数字的和必然为sumAll/3);
 * 否则, 不可以如此划分数组.
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class PartitionArrayIntoThreePartsWithEqualSumSol {
    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; ++i) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int neededSum = sum / 3;
        sum = 0;
        int sumTimes = 0;
        for (int i = 0; i < A.length; ++i) {
            sum += A[i];
            if (sum == neededSum) {
                sum = 0;
                ++sumTimes;
            }
            if (sumTimes == 2 && i != A.length - 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{1,-1,1,-1}));
        System.out.println(canThreePartsEqualSum(new int[]{10,-10,10,-10,10,-10,10,-10}));
        System.out.println(canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1}));
        System.out.println(canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1}));
        System.out.println(canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
    }
}
