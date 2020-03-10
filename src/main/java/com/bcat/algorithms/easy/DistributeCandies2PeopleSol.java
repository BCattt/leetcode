package com.bcat.algorithms.easy;

/**
 * Solution for LeetCode problem 1103 Distribute Candies to People.
 *
 * <p>We distribute some number of candies, to a row of n = num_people people in the following way:
 * <p>>We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.
 * <p>Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.
 * <p>This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).
 * <p>
 * <p>Return an array (of length num_people and sum candies) that represents the final distribution of candies.
 * <p>
 * <p>
 * <p><b>Example 1:</b>
 * <pre>
 * <p><b>Input:</b> candies = 7, num_people = 4
 * <p><b>Output:</b> [1,2,3,1]
 * <p><b>Explanation:</b>
 * <p>On the first turn, ans[0] += 1, and the array is [1,0,0,0].
 * <p>On the second turn, ans[1] += 2, and the array is [1,2,0,0].
 * <p>On the third turn, ans[2] += 3, and the array is [1,2,3,0].
 * <p>On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is [1,2,3,1].
 * </pre>
 * Example 2:
 *
 * Input: candies = 10, num_people = 3
 * Output: [5,2,3]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3].
 * On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
 *  
 *
 * Constraints:
 * <p>
 * 1 {@literal <= } candies {@literal <= } 10^9
 * 1 {@literal <= } num_people {@literal <= } 1000
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class DistributeCandies2PeopleSol {
    public static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int curCandies = 1;
        while (candies > 0) {
            for (int i = 0; i < num_people; ++i) {
                if (candies - curCandies > 0) {
                    result[i] += curCandies;
                    candies -= curCandies;
                    ++curCandies;
                } else {
                    result[i] += candies;
                    candies = 0;
                    break;
                }
            }
        }
        return result;
    }

    public static void print(int[] intArray) {
        System.out.print("[");
        for (int intV : intArray) {
            System.out.print(intV + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        print(distributeCandies(7, 4));
        print(distributeCandies(10, 3));
        print(distributeCandies(1, 3));
        print(distributeCandies(10, 1));
    }
}
