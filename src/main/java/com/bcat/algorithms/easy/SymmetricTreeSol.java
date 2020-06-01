package com.bcat.algorithms.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.bcat.domain.TreeNode;

/**
 * Solution for LeetCode algorithms 101-Symmetric Tree.
 *
 * <p>Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center). For example, this binary tree {@code [1,2,2,3,4,4,3]} is
 * symmetric:
 * <pre>
 *              1
 *             / \
 *            2   2
 *           /\  /\
 *          3  44  3
 * </pre>
 * But the following {@code [1,2,2,null,3,null,3]} is not:
 * <pre>
 *              1
 *             / \
 *            2   2
 *             \   \
 *              3   3
 * </pre>
 * </p>
 * <p>
 * <b>Follow up: </b> Solve it both recursively and iteratively.
 * </p>
 * <p><b>Solution: </b>
 * <p>1. 左节点深度优先遍历结果等于右节点深度优先遍历结果, 则树对称.</p>
 * <p>2. 避免使用递归, 则使用栈来替换递归.</p>
 * </p>
 */
public class SymmetricTreeSol {
    public static boolean isSymmetric(TreeNode root) {
        List<Integer> resultL = new ArrayList<>();
        List<Integer> resultR = new ArrayList<>();

        dfs(root, true, resultL);
        dfs(root, false, resultR);
        return resultL.equals(resultR);
    }

    /**
     * 从所给根节点{@code root}按照方向要求{@code dir}进行深度优先遍历, 并将本次遍历到
     * 的节点存入结果列表中, 如果节点为{@code null}, 则存入0.
     *
     * @param root 树的根节点
     * @param dir true - 左节点, false - 右节点
     * @return
     */
    public static void dfs(TreeNode root, boolean dir, List<Integer> result) {
        if (null != root) {
            result.add(root.val);
            // 根据遍历优先顺序遍历左子树或右子树
            if (dir) {
                dfs(root.left, dir, result);
                dfs(root.left, !dir, result);
            } else {
                dfs(root.right, dir, result);
                dfs(root.right, !dir, result);
            }
        } else {
            result.add(0);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric2(root));

        root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(isSymmetric(root));
        System.out.println(isSymmetric2(root));
    }

    /**
     * 使用栈来模拟
     * @param root
     * @return
     */
    public static boolean isSymmetric2(TreeNode root) {
        List<Integer> rL = new ArrayList<>();
        List<Integer> rR = new ArrayList<>();
        Stack<TreeNode> tStack = new Stack<>();
        // 压入root.right节点
        if (null != root) {
            tStack.push(root.left);
        }
        // 取出当前根节点, 然后开始遍历
        while (!tStack.empty()) {
            // 取出栈顶元素并遍历
            TreeNode t = tStack.pop();
            if (null != t) {
                rL.add(t.val);
                // 左子节点压栈, 右子节点压栈
                tStack.push(t.left);
                tStack.push(t.right);
            } else {
                rL.add(0);
            }
        }
        // 同样对右子树操作
        if (null != root) {
            tStack.push(root.right);
        }
        // 取出当前根节点, 然后开始遍历
        while (!tStack.empty()) {
            // 取出栈顶元素并遍历
            TreeNode t = tStack.pop();
            if (null != t) {
                rR.add(t.val);
                // 左子节点压栈, 右子节点压栈
                tStack.push(t.right);
                tStack.push(t.left);
            } else {
                rR.add(0);
            }
        }
        return rL.equals(rR);
    }
}

