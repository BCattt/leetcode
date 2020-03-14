package com.bcat.algorithms.medium;

import com.bcat.utils.Utils;

import java.util.*;

/**
 * Solution for LeetCode algorithm 39-Combination Sum.
 *
 * <p>Given a <b>set</b> of candidate numbers ({@literal candidates}) (<b>without duplicates</b>)
 * and a target number ({@literal target}), find all unique combinations in candidates where
 * the candidate numbers sums to {@literal target}.
 *   The <b>same</b> repeated number may be chosen from {@literal candidates} unlimited number of times.
 *  <p>Note:
 *  <ul>
 *      <li>All numbers (including {@code target}) will be positive integers.</li>
 *      <li>The solution set must not contain duplicate combinations</li>
 *  </ul>
 *  <p><b>Example 1:</b>
 *  {@code
 *    Input: candidates = [2,3,6,7], target = 7,
 *    A solution set is:
 *    [
 *      [7],
 *      [2,2,3]
 *    ]
 *  }
 *  <p><b>Example 2:</b>
 *  {@code
 *    Input: candidates = [2,3,5], target = 8,
 *    A solution set is:
 *    [
 *      [2,2,2,2],
 *      [2,3,3],
 *      [3,5]
 *    ]
 *  }
 * <p>解题思路:
 * <p>思路1: 利用两数差的思想:
 * Step 1: 对于数组中的每个数candidates[i], 看能否被目标值{@code target}整除, 如果能
 *         整除, 则得到一个结果;
 * Step 2: 假设target / candidates[i] == n, 则将 candidates[i] * 1, candidates[i] * 2, ... candidates[i] * n 都作为
 *         备选数, 先在当前map中筛选是否有数可以加和得target, 然后置入map, key为candidates[i] * k, value为倍数(加数数量).
 * Step 3: 将计算得到的所有组合判重
 *
 * <p>思路2: 回溯+剪枝
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class CombinationSumSol {
    static class Pair {
        int newestNum;
        int[] nums;

        public Pair(int newestNum, int[] nums) {
            this.newestNum = newestNum;
            this.nums = nums;
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Map<Integer, List<Pair>> completeMap = new HashMap<>(candidates.length);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result;
        for (int i = 0; i < candidates.length; ++i) {
            int module = target % candidates[i];
            int divide = target / candidates[i];
            if (module == 0) {
                result = new ArrayList<>(divide);
                // 将可整除数添加到结果中(由于数组中数字不同, 这个组合不可能重复)
                for (int j = 0; j < divide; ++j) {
                    result.add(candidates[i]);
                }
                results.add(result);
                --divide;
            }
            // 对于每个倍数, 将其结果加入
            for (int j = 1; j <= divide; ++j) {
                List<Pair> values;
                int num = candidates[i] * j;
                // 找到了一个组合
                if (null != (values = completeMap.get(target - num))) {
                    // 每个组合加上这个数都是
                    for (Pair value : values) {
                        // 不再重复计算本身
                        if (value.newestNum != candidates[i]) {
                            result = new ArrayList<>(value.nums.length + j);
                            for (int k = 0; k < value.nums.length; ++k) {
                                result.add(value.nums[k]);
                            }
                            for (int k = 0; k < j; ++k) {
                                result.add(candidates[i]);
                            }
                            results.add(result);
                        }
                    }
                  // 未找到组合, 则将当前数加到差集中的每个元素上, 如果 < target, 则保存, 否则不保存
                }
                Map<Integer, List<Pair>> toAdd = new HashMap<>();
                // 先将自身增加到待添加Map中
                int[] nums;
                List<Pair> pairs;
                for (Integer key : completeMap.keySet()) {
                    // 对于每个数, 加上candidates[i] * j < target, 则将此数加入completeMap
                    if (key + num < target) {
                        pairs = toAdd.computeIfAbsent(key + num, k -> new ArrayList<>());
                        List<Pair> oldPairs = completeMap.get(key);
                        for (Pair oldPair : oldPairs) {
                            // 不处理自身
                            if (oldPair.newestNum != candidates[i]) {
                                nums = Arrays.copyOf(oldPair.nums, oldPair.nums.length + j);
                                Arrays.fill(nums, oldPair.nums.length, nums.length, candidates[i]);
                                pairs.add(new Pair(candidates[i], nums));
                            }
                        }
                    }
                }
                for (Map.Entry<Integer, List<Pair>> entry : toAdd.entrySet()) {
                    completeMap.computeIfAbsent(entry.getKey(), k -> new ArrayList<>(entry.getValue().size())).addAll(entry.getValue());
                }

                // 将此数存入差map中
                List<Pair> value = completeMap.computeIfAbsent(num, k -> new ArrayList<>());
                nums = new int[j];
                Arrays.fill(nums, candidates[i]);
                value.add(new Pair(candidates[i], nums));
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<List<Integer>> results = combinationSum(new int[]{2,3,6,7}, 7);
        Utils.print2DList(results);
        Utils.print2DList(combinationSum(new int[]{2,3,5}, 8));
        Utils.print2DList(combinationSum(new int[]{2}, 2));
        Utils.print2DList(combinationSum(new int[]{1}, 2));
        Utils.print2DList(combinationSum(new int[]{}, 2));
        Utils.print2DList(combinationSum(new int[]{2,3,7}, 18));
    }
}
