package com.bcat.algorithms.easy;

import java.util.Arrays;

public class DesignHashMapSol {
    static class MyHashMap {
        private int[] values;
        private int capacity;

        /** Initialize your data structure here. */
        public MyHashMap() {
            capacity = 1 >> 4;
            values = new int[capacity];
            Arrays.fill(values, -1);
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            if (key >= capacity) {
                capacity = key + 1;
                int[] newValues = new int[capacity];
                System.arraycopy(values, 0, newValues, 0, values.length);
                Arrays.fill(newValues, values.length, newValues.length, -1);
                values = newValues;
            }
            values[key] = value;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            if (key >= capacity) {
                return -1;
            }
            return values[key];
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            if (key < capacity) {
                values[key] = -1;
            }
        }
    }
}
