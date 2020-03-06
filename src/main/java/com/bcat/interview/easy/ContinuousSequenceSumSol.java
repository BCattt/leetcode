package com.bcat.interview.easy;

import com.bcat.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for LeetCode problem Interview 57-II 和为s的连续正数序列.
 *
 * <p>输入一个正整数{@code target}, 输出所有和为{@code target}的连续正整数序列(至少含有两个数)。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p><b>示例1: </b>
 * {@literal
 *   输入: target = 9
 *   输出: [[2,3,4],[4,5]]
 * }
 * <p><b>示例2: </b>
 *  * {@literal
 *  *   输入: target = 15
 *  *   输出: [[1,2,3,4,5],[4,5,6],[7,8]]
 *  * }
 *
 * <p>解题思路:
 * <p>思路1:
 * 连续正整数是一个等差数列，假设第一个数为x, 当前整数个数为n, 则可以得到以下公式
 * x * n + n * (n - 1) / 2 = t, 由此, x = (2t + n - n^2) / 2n
 * 当n = 2时，x最大, 如果可以计算得到x的值, 则得到一个结果
 * 当n = 3时, x次之, 如果可以计算得到x的值, 则得到一个结果
 * ...
 * 直到 2t + n - n^2小于0，搜索结束
 *
 * <p>思路2:
 * 从1开始到 t/2 + 1, 累加求和, 当累加和==t时, 为一个答案; 如果累加和> t, 则重新
 * 从当前位置的下一个位置开始累加, 直到累加和==t或>t
 * @author <a href="zjebusiness@gmail.com">赵峻</a>
 */
public class ContinuousSequenceSumSol {
    public static int[][] findContinuousSequence(int target) {
        List<int[]> answerList = new ArrayList<>();
        // 从2长度开始搜索
        int answerLen = 2;
        // 答案的第一个数字
        int x = 0;
        int left;
        do {
            // 根据公式，计算差
            left =  2 * target + answerLen - answerLen * answerLen;
            if (left % (2 * answerLen) == 0) {
                x = left / (2 * answerLen);
                // x是有效的值, 找到一个答案
                if (x >= 1) {
                    int[] answerT = new int[answerLen];
                    for (int i = 0; i < answerLen; ++i) {
                        answerT[i] = x + i;
                    }
                    answerList.add(answerT);
                }
            }
            // 搜索下一个答案
            ++answerLen;
        } while (left > 0);
        int[][] answer = new int[answerList.size()][];
        // 倒序即是所需顺序
        for (int i = answerList.size(); i > 0; --i) {
            answer[answerList.size() - i] = answerList.get(i - 1);
        }
        return answer;
    }

    public static int[][] findContinuousSequence2(int target) {
        List<int[]> answerList = new ArrayList<>();
        int currSum = 0;
        int curStart = 1;
        List<Integer> currAnswer = new ArrayList<>();
        for (int i = curStart; i <= target / 2 + 1; ++i) {
            currSum += i;
            currAnswer.add(i);
            if (currSum == target) {
                answerList.add(currAnswer.stream().mapToInt(v->v).toArray());
            }
            if (currSum >= target) {
                currSum = 0;
                currAnswer = new ArrayList<>();
                curStart++;
                i = curStart;
            }
        }
        int[][] answer = new int[answerList.size()][];
        for (int i = 0; i < answerList.size(); ++i) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int target = 1;
        int[][] answer;
        long start, end;
        System.out.println("target = " + target);
        start = System.nanoTime();
        answer = findContinuousSequence(target);
        end = System.nanoTime();
        System.out.print("time = " + (end - start) / 1_000_000 + "ms ");
        Utils.print2DArray(answer);
        start = System.nanoTime();
        answer = findContinuousSequence2(target);
        end = System.nanoTime();
        System.out.print("time = [" + (end - start) / 1_000_000 + "ms ");
        Utils.print2DArray(answer);

        target = 2;
        System.out.println("target = " + target);
        Utils.print2DArray(findContinuousSequence(target));
        Utils.print2DArray(findContinuousSequence2(target));

        target = 3;
        System.out.println("target = " + target);
        Utils.print2DArray(findContinuousSequence(target));
        Utils.print2DArray(findContinuousSequence2(target));

        target = 4;
        System.out.println("target = " + target);
        Utils.print2DArray(findContinuousSequence(target));
        Utils.print2DArray(findContinuousSequence2(target));

        target = 7;
        System.out.println("target = " + target);
        Utils.print2DArray(findContinuousSequence(target));
        Utils.print2DArray(findContinuousSequence2(target));

        target = 9;
        System.out.println("target = " + target);
        Utils.print2DArray(findContinuousSequence(target));
        Utils.print2DArray(findContinuousSequence2(target));

        target = 10;
        System.out.println("target = " + target);
        Utils.print2DArray(findContinuousSequence(target));
        Utils.print2DArray(findContinuousSequence2(target));

        target = 11;
        System.out.println("target = " + target);
        Utils.print2DArray(findContinuousSequence(target));
        Utils.print2DArray(findContinuousSequence2(target));

        target = 13;
        System.out.println("target = " + target);
        Utils.print2DArray(findContinuousSequence(target));
        Utils.print2DArray(findContinuousSequence2(target));

        target = 15;
        System.out.println("target = " + target);
        Utils.print2DArray(findContinuousSequence(target));
        Utils.print2DArray(findContinuousSequence2(target));

        target = 21;
        System.out.println("target = " + target);
        Utils.print2DArray(findContinuousSequence(target));
        Utils.print2DArray(findContinuousSequence2(target));
    }
}
