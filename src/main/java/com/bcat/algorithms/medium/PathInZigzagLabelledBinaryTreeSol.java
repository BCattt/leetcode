package com.bcat.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution for leetcode 1104 - Path In ZigZag Labelled Binary Tree.
 */
public class PathInZigzagLabelledBinaryTreeSol {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        pathInZigZagTree(label, ans);
        Collections.reverse(ans);
        return ans;
    }

    int layer(int label) {
        int layer = 0;
        while (label >= 1) {
            ++layer;
            label /= 2;
        }
        return layer;
    }

    private void pathInZigZagTree(int label, List<Integer> path) {
        path.add(label);
        if (label == 1) {
            return;
        }
        int layer = layer(label);
        int first = 1 << (layer - 1);
        int pos = (label - first) / 2;
        int parentLast = first - 1;
        pathInZigZagTree(parentLast - pos, path);
    }

    public static void main(String[] args) {
        PathInZigzagLabelledBinaryTreeSol sol = new PathInZigzagLabelledBinaryTreeSol();
        System.out.println(sol.pathInZigZagTree(14));
        System.out.println(sol.pathInZigZagTree(1));
        System.out.println(sol.pathInZigZagTree(2));
        System.out.println(sol.pathInZigZagTree(3));
        System.out.println(sol.pathInZigZagTree(4));
        System.out.println(sol.pathInZigZagTree(15));
    }
}
