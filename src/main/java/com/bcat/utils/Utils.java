package com.bcat.utils;

import com.bcat.domain.ListNode;

import java.util.ArrayList;
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
}
