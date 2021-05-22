package com.bcat.algorithms.medium;

import com.bcat.domain.TreeNode;
import com.bcat.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for leetcode 113 - Path Sum II.
 */
public class PathSumIISol {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        dfs(root, targetSum, 0, results, result);
        return results;
    }

    private void dfs(TreeNode root, int targetSum, int currSum, List<List<Integer>> results, List<Integer> path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // leaf node
            if (currSum + root.val == targetSum) {
                path.add(root.val);
                results.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
        } else {
            path.add(root.val);
            dfs(root.left, targetSum, currSum + root.val, results, path);
            dfs(root.right, targetSum, currSum + root.val, results, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        PathSumIISol sol = new PathSumIISol();
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(11);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);
//
        TreeNode root = Utils.makeBinaryTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});

        System.out.println(sol.pathSum(root, 22));
    }
}
