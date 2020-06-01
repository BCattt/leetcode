package com.bcat.algorithms.easy;

import com.bcat.domain.TreeNode;

/**
 * Solution for LeetCode 226 - Invert Binary Tree.
 *
 * <p>Invert a binary tree. </p>
 * <p><b>Example: </b><pre>
 * Input:
 *                 4
 *               /   \
 *              2     7
 *            /  \  /  \
 *           1   3 6    9
 * Output:
 *                 4
 *               /   \
 *              7     2
 *            /  \  /  \
 *           9   6 3    1
 * </pre></p>
 * <p><b>Solution: </b><pre>
 * 1. 递归
 * 广度优先遍历, 从叶子节点开始, 交换左、右子树, 然后交换左子树的左右子树; 右子树的左右子树,
 * 直到叶子节点.
 * </pre></p>
 */
public class InvertBinaryTreeSol {
    public static TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    static void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        // 交换左右子树
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        // 继续交换
        invert(root.left);
        invert(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        invertTree(root);

        root = new TreeNode(4);
        invertTree(root);

        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        invertTree(root);
    }
}
