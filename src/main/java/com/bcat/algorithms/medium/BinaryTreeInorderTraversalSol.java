package com.bcat.algorithms.medium;

import com.bcat.domain.Pair;
import com.bcat.domain.TreeNode;
import com.bcat.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Solution for LeetCode Algorithm problem 94-Binary Tree Inorder Traversal.
 * <p>
 * Given a binary tree, return the <i>inorder</i> traversal of its nodes' values.
 * </p>
 * <p><b>Example: </b>
 * {@literal
 *   Input: [1,null,2,3]
 *   1
 *    \
 *     2
 *    /
 *   3
 * Output: [1,3,2]
 * }
 * </p>
 * <p><b>Follow up:</b> Recursive solution if trivial, could you do it iteratively?
 * </p>
 * <p>解题思路:
 * <p><b>思路1:</b>
 * 使用递归, 先遍历左子树, 再遍历右孺子树. 终止条件就是到达叶子结点.
 * </p>
 * <p><b>思路2:</b>
 * 不使用递归, 使用一个栈来保存待处理的节点及其左子树的处理状态(防止重复处理).
 * 当栈不空时:
 * <ol>
 *   <li>查看栈顶元素, 将其所有左子树节点压栈, 状态为已处理</li>
 *   <li>取出栈顶元素(此时就是最左叶子节点), 将其值加入结果列表</li>
 *   <li>将栈顶元素的右节点压栈, 状态为<b>未处理</b>(因为其左子树尚未压栈)</li>
 *   <li>重复步骤1</li>
 * </ol>
 * </p>
 * </p>
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class BinaryTreeInorderTraversalSol {
    /**
     * 递归解法
     * @param root 树的根节点
     * @return 树的中序遍历结果
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (null == root) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> traversal = new ArrayList<>();
        traversal.addAll(inorderTraversal(root.left));
        traversal.add(root.val);
        traversal.addAll(inorderTraversal(root.right));
        return traversal;
    }

    /**
     * 使用栈实现树的中序遍历
     * @param root 树的根节点
     * @return 树的中序遍历结果
     */
    public static List<Integer> inorderTraversalStack(TreeNode root) {
        if (null == root) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> traversal = new ArrayList<>();
        Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
        // 根节点入栈
        stack.push(new Pair<>(root, false));

        while (!stack.empty()) {
            // 对于栈顶元素, 先访问其左子树, 直到遇到null, 访问其右子树
            Pair<TreeNode, Boolean> node = stack.peek();
            if (node.v1.left != null && ! node.v2) {
                TreeNode left = node.v1.left;
                while (null != left) {
                    stack.push(new Pair<>(left, true));
                    left = left.left;
                }
                // 此节点已经处理过左子树
                node.v2 = true;
            }
            // 到达最左叶子节点, 开始处理
            node = stack.pop();
            traversal.add(node.v1.val);
            // 处理当前节点的右子树
            if (null != node.v1.right) {
                stack.push(new Pair<>(node.v1.right, false));
            }
        }
        return traversal;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = inorderTraversal(root);
        System.out.println(Utils.list2Str(result));
        result = inorderTraversalStack(root);
        System.out.println(Utils.list2Str(result));
        //            1
        //          /   \
        //         2     3
        //              /
        //             4
        // 2,1,4,3
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        System.out.println(Utils.list2Str(inorderTraversalStack(root)));

        //       2
        //      /
        //     3
        //    /
        //   1
        root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        System.out.println(Utils.list2Str(inorderTraversalStack(root)));
    }
}
