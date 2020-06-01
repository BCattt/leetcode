package com.bcat.algorithms.easy;

import com.bcat.domain.TreeNode;

/**
 * Solution for LeetCode Algorithm 104-Maximum Depth of Binary Tree.
 * <p>Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * <b>Note: </b>A leaf is a node with no children.
 * </p>
 * <p><b>Example: </b><pre>
 * Given binary tree {@code [3,9,20,null,null,15,7]}.
 *             3
 *            / \
 *           9  20
 *              /\
 *            15  7
 * return its depth = 3.
 * </pre></p>
 * <p>Solution:
 * <p>深度优先搜索, 第到达一个叶子节点, 记录其递归深度, 即得到此叶子节点的尝试, 取最大值即可.</p>
 * </p>
 */
public class MaximumDepthOfBinaryTreeSol {
    public static int maxDepth(TreeNode root) {
        int curDepth = 0;
        return dfs(root, curDepth);
    }

    private static int dfs(TreeNode root, int curDepth) {
        // 叶子节点, 搜索停止
        if (null == root) {
            return curDepth;
        }
        // 非叶子节点, 则尝试增加1
        ++curDepth;
        // 取左子树和右子树的最大深度
        return Math.max(dfs(root.left, curDepth), dfs(root.right, curDepth));
    }

    public static void main(String[] args) {
        //        3
        //       / \
        //      9   20
        //         /  \
        //        15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        // 3
        System.out.println(maxDepth(root));

        //             3
        //            / \
        //           9  20
        //          /   / \
        //         10  15  7
        //             /
        //            8
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        // 4
        System.out.println(maxDepth(root));
    }
}
