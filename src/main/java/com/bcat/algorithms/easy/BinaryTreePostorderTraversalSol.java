package com.bcat.algorithms.easy;

import com.bcat.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for leetcode 145 - Binary Tree Postorder Traversal.
 */
public class BinaryTreePostorderTraversalSol {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsPostorder(root, result);
        return result;
    }

    private void dfsPostorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        dfsPostorder(root.left, result);
        dfsPostorder(root.right, result);
        result.add(root.val);
    }

}
