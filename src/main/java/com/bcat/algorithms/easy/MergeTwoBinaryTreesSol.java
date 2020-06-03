package com.bcat.algorithms.easy;

import com.bcat.domain.TreeNode;

/**
 * Solution for LeetCode algorithm 617 - Merge Two Binary Trees.
 *
 * <p>Given two binary trees and imagine that when you put one of them to cover
 * the other, some nodes of two trees are overlapped while the others are not.</p>
 * <p>You need to merge them into a new binary tree. The merge rule is that if
 * two nodes overlap, then sum node values up as the new value of the merged
 * node. Otherwise, the NOT null node will be used as the node of new tree.</p>
 * <p><b>Example 1:</b><pre>
 *     <b>Input: </b>
 *                 Tree 1                         Tree 2
 *                   1                              2
 *                  / \                            / \
 *                 3   2                          1   3
 *                /                                \   \
 *               5                                  4   7
 *     <b>Output: </b>
 *     Merged Tree:
 *                 3
 *                / \
 *               4   5
 *              / \   \
 *             5  4    7
 * </pre></p>
 * <p><b>Note: </b>The merging process must start from the root nodes of both trees.</p>
 * <p><b>Solution: </b>
 *     Modify the first tree in-place. 同时广度优先遍历树1和树2, 如果有相应节点, 则将
 *  其值加到树1; 如果无相应节点, 则使用树1的节点; 如果树1无相应节点, 而树2有, 则直接使用
 *  树2的节点.
 * </p>
 */
public class MergeTwoBinaryTreesSol {
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 如果t1为不空且t2不空, 则合并节点, 并继续merge
        if (null != t1 && null != t2) {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        // 如果t1不空, 而t2不空, 则返回t1的节点
        } else if (null != t1) {
            return t1;
        // 如果t1空, 而t2不空, 则返回t2的节点
        } else if (null != t2) {
            return t2;
        } else {
            // 两个都为空, 则返回null
            return null;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);
        //            1                2                  3
        //           / \              / \                / \
        //          3   2    +       1   3    =         4   5
        //         /                  \   \            / \   \
        //        5                    4   7          5   4   7
        mergeTrees(root1, root2);

        root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);

        root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);
        //          1         2                  3
        //         /           \                / \
        //        3      +      3      =       3   3
        //       /               \            /     \
        //      5                 7          5       7
        mergeTrees(root1, root2);
    }
}
