package com.bcat.algorithms.easy;

import com.bcat.domain.TreeNode;

/**
 * Solution for LeetCode Algorithm problem 534-Diameter of Binary Tree.
 *
 * <p>Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p><b>Example:</b>
 * Given a binary tree
 * {@code
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * }
 * <p>Return <b>3</b>, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p><b>Note:</b> The length of path between two nodes is represented by the number of edges between them.
 *
 * <p>解题思路:
 * 某个节点左子树的最长路径 + 其右子树的最长路径即得到其diameter.
 * 因此, 这个问题转换成深度优先遍历二叉树问题.
 *
 * 从根节点开始, 计算其左子树的最长路径; 然后计算其右子树的最长路径. diameterLeft + diameterRight即得到此节点
 * 为根的树的diameter. 如果某个节点没有左子树, 则其左子树的diameter是0; 如果某个节点没有右子树, 则其右子树的diameter是0.
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class DiameterOfBinaryTreeSol {
    private static int diameter = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        subTreeDiameter(root);
        return diameter;
    }

    public static int subTreeDiameter(TreeNode root) {
        int leftDiameter = 0, rightDiameter = 0;
        // 左子节点不空, 计算左子节点最长路径
        if (root.left != null) {
            leftDiameter = subTreeDiameter(root.left) + 1;;
        }
        // 右子节点不空, 计算右子节点最长路径
        if (root.right != null) {
            rightDiameter = subTreeDiameter(root.right) + 1;
        }
        if (leftDiameter + rightDiameter > diameter) {
            diameter = leftDiameter + rightDiameter;
        }
        return leftDiameter > rightDiameter ? leftDiameter : rightDiameter;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        //
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        System.out.println(diameterOfBinaryTree(root));
        //             1
        //            / \
        //           2   5
        //          /
        //         3
        //        /
        //       4
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));

        //           1
        //          /
        //         2
        //        /
        //       3
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(diameterOfBinaryTree(root));
    }
}
