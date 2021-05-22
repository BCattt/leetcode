package com.bcat.algorithms.easy;

import com.bcat.algorithms.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for leetcode 590 N-ary Tree Postorder Traversal.
 */
public class NaryTreePostorderTraversalSol {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        bfsPostorder(root, result);
        return result;
    }

    private void bfsPostorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.children == null || root.children.isEmpty()) {
            result.add(root.val);
            return;
        }
        for (Node child : root.children) {
            bfsPostorder(child, result);
        }
        result.add(root.val);
    }
}
