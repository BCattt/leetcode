package com.bcat.algorithms.easy;

/**
 * Solution for LeetCode 461 - Hamming Distance.
 *
 * <p>The Hamming distance between two integers is the number of positions at
 * which the corresponding bits are different. Given two integers {@code x} and
 * {@code y}, calculate the Hamming distance.</p>
 * <p><b>Note: </b><pre>
 * {@code 0 <= x, y < 2^31}
 * </pre></p>
 * <p><b>Example: </b><pre>
 *     <b>Input: </b>x = 1, y = 4
 *     <b>Output: </b>2
 *     <b>Explanation: </b>
 *     1  (0 0 0 1)
 *     4  (0 1 0 0)
 *           ^   ^
 *     The above arrows point to positions where the corresponding bits are
 * different.
 * </pre></p>
 * <p><b>Solution: </b><pre>
 *     即统计两个整数二进制位不相同的个数, 取两个整数的异或(^), 然后计算结果中1的个数即可.
 * </pre></p>
 *
 * @date 02/06/2020
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class HammingDistanceSol {
    public static int hammingDistance(int x, int y) {
        int result = x ^ y;
        int answer = 0;
        while (result != 0) {
            if (result % 2 == 1) {
                ++answer;
            }
            result /= 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
        System.out.println(hammingDistance(0,0));
        System.out.println(hammingDistance(0,1));
    }
}
