package com.bcat.algorithms.medium;

import com.bcat.domain.TreeNode;

public class BinarySearchTreeIteratorSol {
    private static final int MAX_SZ = 100_000;
    static class BSTIterator {
        final TreeNode root;
        final int[] data;
        int sz;
        int currPos;
        public BSTIterator(TreeNode root) {
            this.root = root;
            data = new int[MAX_SZ];
            sz = 0;
            inOrderTraversal(root);
            currPos = 0;
        }

        public int next() {
            return data[currPos++];
        }

        public boolean hasNext() {
            return currPos < sz;
        }

        private void inOrderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrderTraversal(root.left);
            data[sz] = root.val;
            ++sz;
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator it = new BSTIterator(root);
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());

        root = new TreeNode(1);
        it = new BSTIterator(root);
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
    }
}
