package com.bcat.utils;

import com.bcat.domain.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static void printList(ListNode list) {
        List<Integer> iList = new ArrayList<>();
        while (null != list) {
            iList.add(list.val);
            list = list.next;
        }
        System.out.println(iList.stream().map(String::valueOf).collect(Collectors.joining("->")));
    }

    public static void print2DArray(int[][] array) {
        List<String> strList = new ArrayList<>(array.length);
        for (int i = 0; i < array.length; ++i) {
            strList.add("[" + Arrays.stream(array[i]).mapToObj(String::valueOf).collect(Collectors.joining(",")) + "]");
        }
        System.out.println(strList.stream().collect(Collectors.joining(",")));
    }
}
