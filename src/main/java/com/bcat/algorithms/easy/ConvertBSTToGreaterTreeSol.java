package com.bcat.algorithms.easy;

import com.bcat.domain.TreeNode;

/**
 * Solution for LeetCode algorithm 538 - Convert BST to Greater Tree.
 *
 * <p>Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus sum of all
 * keys greater than the original key in BST.</p>
 * <p><b>Example: </b><pre>
 *     <b>Input: </b>The root of a Binary Search Tree like this:
 *                  5
 *                 / \
 *                2  13
 *     <b>Output: </b>The root of a Greater Tree like this:
 *                 18
 *                / \
 *              20  13
 * </pre></p>
 * <p><b>Note: </b>This question is the same as 1038: Binary Search Tree to Greater
 * sum tree.</p>
 * <p><b>Solution: </b>
 * <p><b>1. 递归-深度优先遍历右子树</b><pre>
 *     每个节点需要加上所有比它大的节点和, 因此, 可以采用尝试优先右子树遍历, 在遍历过程中,
 * 对所有遍历过的节点进行累加, 增加到当前节点, 即可一次遍历完成求解.
 * </p>
 * <p><b>2. 迭代</b><pre>
 *     使用栈来避免尾递归.
 * </pre></p>
 * </pre></p>
 *
 * @date 02/06/2020
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class ConvertBSTToGreaterTreeSol {
    public static TreeNode convertBST(TreeNode root) {
        dfsR(root, 0);
        return root;
    }

    /**
     * 右子树深度优先遍历
     * @param root 当前节点
     * @param gtSum 所有大于当前节点和
     *
     * @return 当前节点累积和(即比当前节点大的值 + 当前节点值)
     */
    private static int dfsR(TreeNode root, int gtSum) {
        // 达到叶子节点, 返回添加和0
        if (null == root) {
            return 0;
        }

        // 中间节点, 加上其右边及父所有节点的和
        int tmp = root.val;
        // 计算当前节点所有右节点累积和
        int rSum = dfsR(root.right, gtSum);
        // 当前的值为rSum + gtSum
        root.val += rSum + gtSum;
        // 左子树以root.val + sum为起点(即左子树的父节点所有节点累积和)
        rSum += tmp;
        int lSum = dfsR(root.left, rSum + gtSum);

        return rSum + lSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        convertBST(root);

        root = new TreeNode(5);
        convertBST(root);

        root.left = new TreeNode(2);
        convertBST(root);

        //       5                          5
        //      /                          /
        //     2             ->           7
        //    /                          /
        //   1                          8

        root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        convertBST(root);

        //                  2                  5
        //                /   \              /   \
        //               0     3    ->      6     3
        //              / \                / \
        //            -4   1              2   6
        root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);
        convertBST(root);

        //              2                         18
        //            /  \                      /   \
        //           1    6       ->           19   13
        //               / \                       /  \
        //              3   7                     16   7
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        convertBST(root);
    }
}
