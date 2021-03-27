package com.bcat.algorithms.easy;

import java.util.Arrays;

public class DesignHashSetSol {
    public static class MyHashSet {
        private final boolean[] keys;
        public MyHashSet() {
            keys = new boolean[1_000_000 + 1];
            Arrays.fill(keys, false);
        }
        public void add(int key) {
            keys[key] = true;
        }

        public void remove(int key) {
            keys[key] = false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return keys[key];
        }
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(6);
        myHashSet.remove(17);
        myHashSet.add(14);
        myHashSet.contains(14);
        myHashSet.add(17);
        myHashSet.remove(14);
        myHashSet.add(14);
        myHashSet.add(14);
        myHashSet.add(18);
        myHashSet.add(14);
    }
}
