package com.bcat.utils;

import com.bcat.domain.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utilities for viewing algorithm result
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class Utils {
    /**
     * Print a list node an concatenate each node with {@literal ->}.
     *
     * @param list head node of a linked list.
     */
    public static void printList(ListNode list) {
        List<Integer> iList = new ArrayList<>();
        while (null != list) {
            iList.add(list.val);
            list = list.next;
        }
        System.out.println(iList.stream().map(String::valueOf).collect(Collectors.joining("->")));
    }

    public static void printIntArray(int[] intArray) {
        System.out.println(Arrays.stream(intArray).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    public static String intArray2String(int[] intArray) {
        return intArray2String(intArray, ",");
    }

    public static String intArray2String(int[] intArray, String sep) {
        return Arrays.stream(intArray).mapToObj(String::valueOf).collect(Collectors.joining(sep));
    }

    public static void print2DArray(int[][] array) {
        List<String> strList = new ArrayList<>(array.length);
        for (int i = 0; i < array.length; ++i) {
            strList.add("[" + Arrays.stream(array[i]).mapToObj(String::valueOf).collect(Collectors.joining(",")) + "]");
        }
        System.out.println(strList.stream().collect(Collectors.joining(",")));
    }

    public static void print2DList(List<List<Integer>> list) {
        System.out.println(list.stream().map(
            l -> "[" + l.stream().map(String::valueOf).collect(Collectors.joining(",")) + "]")
        .collect(Collectors.joining(",")));
    }
}
