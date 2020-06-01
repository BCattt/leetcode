package com.bcat.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

import com.bcat.utils.Utils;

/**
 * Solution for LeetCode Algorithms 1431 - Kids With the Greatest Number of Candies.
 *
 * <p>Given the array {@code candies} and the integer {@code extraCandies}, where
 * {@code candies[i]} represents the number of candies that the <b>ith</b> kid has.
 * For each kid check if there is a way to distribute {@code extraCandies} among
 * the kids such that he or she can have the <b>greatest</b> number of candies
 * among them. Notice that multiple kids can have the <b>greatest</b> number of
 * candies.
 * </p>
 *
 * <p><p><b>Example 1: </b><pre>
 *     <b>Input: </b> candies = [2,3,5,1,3], extraCandies = 3
 *     <b>Output: </b>[true,true,true,false,true]
 *     <b>Explanation: </b><pre>
 *     Kid 1 has 2 candies and if he or she receives all extra candies (3) will
 *     have 5 candies --- the greatest number of candies among the kids.
 *     Kid 2 has 3 candies and if he or she receives at least 2 extra candies will
 *     have the greatest number of candies among the kids.
 *     Kid 3 has 5 candies and this is already the greatest number of candies among the kids.
 *     Kid 4 has 1 candy and even if he or she receives all extra candies will only have 4 candies.
 *     Kid 5 has 3 candies and if he or she receives at least 2 extra candies will have
 *     the greatest number of candies among the kids.
 *     </pre></pre>
 * <p><b>Example 2: </b><pre>
 *     <b>Input: </b>candies = [4,2,1,1,2], extraCandies = 1
 *     <b>Output: </b>[true, false, false, false, false]
 *     <b>Explanation: </b><pre>
 *     There is only 1 extra candy, therefore only kid 1 will have the greatest number
 *     of candies among the kids regardless of who takes the extra candy.
 *     </pre></pre></p>
 * <p><b>Example 3: </b><pre>
 *     <b>Input: </b>candies = [12,1,12], extraCandies = 10
 *     <b>Output: </b>[true, false, true]
 * </pre></p>
 * <p><b>Constraints: </b><ul>
 *     <li>{@code 2 <= candies.length <= 100}</li>
 *     <li>{@code 1 <= candies[i] <= 100}</li>
 *     <li>{@code 1 <= extraCandies <= 50}</li>
 * </ul></p>
 * </p>
 *
 * <p>Solution:
 * <p>计算数组中的最大值max, 如果某个数ai >= (max - extra), 则ai + extra必然能到达最大值.
 * 时间复杂度: O(n); 空间复杂度: O(1).</p>
 * </p>
 *
 * @date 01/06/2020
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class KidsWithTheGreatestNumOfCandiesSol {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }
        List<Boolean> answer = new ArrayList<>(candies.length);
        for (int candy : candies) {
            if (candy >= (max - extraCandies)) {
                answer.add(true);
            } else {
                answer.add(false);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Utils.list2Str(kidsWithCandies(new int[]{2,3,5,1,3}, 3)));
        System.out.println(Utils.list2Str(kidsWithCandies(new int[]{4,2,1,1,2}, 1)));
        System.out.println(Utils.list2Str(kidsWithCandies(new int[]{12,1,12}, 1)));
    }
}
