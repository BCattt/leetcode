package com.bcat.algorithms.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Solution for leetcode 981 - Time Based Key-Value Store.
 */
public class TimeBasedKeyValueStoreSol {
    class TimeMap {
        Map<String, TreeMap<Integer, String>> store;

        /** Initialize your data structure here. */
        public TimeMap() {
            store = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            Map<Integer, String> val = store.compute(key, (k, v) -> v == null ? new TreeMap<>() : v);
            val.put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> val = store.get(key);
            if (val == null) {
                return "";
            }
            if (!val.containsKey(timestamp)) {
                Map.Entry<Integer, String> target = val.floorEntry(timestamp);
                if (target == null) {
                    return "";
                }
                return target.getValue();
            } else {
                return val.get(timestamp);
            }
        }
    }
}
