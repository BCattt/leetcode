package com.bcat.algorithms.easy;

import com.bcat.domain.TreeNode;

/**
 * Solution for LeetCode algorithm 437 - Path Sum III.
 *
 * <p>You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value. The path does not need to
 * start or end at the root or a leaf, but it must go downwards (traveling only
 * from parent nodes to child nodes). The tree has no more than 1,000 nodes and
 * the values are in the range -1,000,000 to 1,000,000.</p>
 * <p><b>Example: </b><pre>
 *     root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *                   10
 *                  /  \
 *                5    -3
 *              /  \    \
 *             3   2     11
 *            / \   \
 *           3  -2  1
 *     Returns 3. The paths that sum to 8 are:
 *     1. 5 -> 3
 *     2. 5 -> 2 -> 1
 *     3. -3 -> 11
 * </pre></p>
 * <p><b>Solution: </b>
 * <p>1. 回溯</p><pre>
 *     使用左子树深度优先遍历, 从根节点开始向下遍历, 每遍历一个节点则从目标值中减掉当前节点
 * 值, 在子树中查找此差, 找到就有一条正确的路径; 否则, 遍历到叶子节点也没有, 则无正确路径.
 * </pre></p>
 *
 * @date 02/06/2020
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class PathSum3Sol {
    public static int pathSum(TreeNode root, int sum) {
        // 深度优先遍历查找结果
        return traverse(root, sum);
    }

    public static int traverse(TreeNode root, int sum) {
        if (null != root) {
            int answer = 0;
            // 找到一个答案, 则先增加1, 再找后续和为0的路径
            if (0 == sum - root.val) {
                answer = 1;
            }
            // 当前节点左子树查找 sum - root.val
            answer += findSum(root.left, sum - root.val) +
                    // 当前节点右子树查找 sum - root.val
                    findSum(root.right, sum - root.val) +
                    // 在不包含当前节点的左子树查找
                    traverse(root.left, sum) +
                    // 在不包含当前节点的右子树查找
                    traverse(root.right, sum);

            return answer;
        }
        return 0;
    }

    public static int findSum(TreeNode root, int sum) {
        // 达到叶子节点, 回溯
        if (null == root) {
            return 0;
        }
        int answer = 0;
        // 找到一个答案, 则增加答案数, 并继续查找
        if (0 == sum - root.val) {
            answer = 1;
        }
        // 未找到答案, 先查左子树, 再查右子树
        return answer + findSum(root.left, sum - root.val) +
        findSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        // 3
        System.out.println(pathSum(root, 8));
        //1
        root = new TreeNode(1);
        System.out.println(pathSum(root, 1));

        // 2
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(pathSum(root, 3));

        // 1
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        System.out.println(pathSum(root, 1));

        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(-1);
        root.right.left = new TreeNode(-2);
        // 4
        System.out.println(pathSum(root, -1));
        // 4
        System.out.println(pathSum(root, -2));
    }


}
