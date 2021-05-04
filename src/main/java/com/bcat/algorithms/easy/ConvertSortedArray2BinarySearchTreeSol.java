package com.bcat.algorithms.easy;

import com.bcat.domain.TreeNode;

/**
 * Solution for leetcode 108 - Convert Sorted Array to Binary Search Tree.
 */
public class ConvertSortedArray2BinarySearchTreeSol {
    public TreeNode sortedArrayToBST(int[] nums) {
        int sz = nums.length / 2;
        TreeNode root = new TreeNode(nums[sz]);
        TreeNode left = root;
        for (int i = sz - 1; i >= 0; --i) {
            left.left = new TreeNode(nums[i]);
            left = left.left;
        }
        TreeNode right = root;
        for (int i = sz + 1; i < nums.length; ++i) {
            right.right = new TreeNode(nums[i]);
            right = right.right;
        }
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArray2BinarySearchTreeSol sol = new ConvertSortedArray2BinarySearchTreeSol();
        int[] nums;
        TreeNode result;
        nums = new int[]{1, 3};
        result = sol.sortedArrayToBST(nums);

        nums = new int[]{-10, -3, 0, 5, 9};
        result = sol.sortedArrayToBST(nums);

        nums = new int[]{0};
        result = sol.sortedArrayToBST(nums);
    }
}
