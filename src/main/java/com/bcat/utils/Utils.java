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
    public static void printLinkedList(ListNode list) {
        System.out.println(linkedList2String(list));
    }
    /**
     * 将链表转换成字符串, 格式为: 数字 -> ...
     * @param list 待转换的链表
     * @return 转换后的字符串
     */
    public static String linkedList2String(ListNode list) {
        StringBuilder sb = new StringBuilder();
        while (null != list) {
            sb.append(list.val).append("->");
            list = list.next;
        }
        // 删除最后一个分隔符
        if (sb.length() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }

    public static void printIntArray(int[] intArray) {
        System.out.println(Arrays.stream(intArray).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    public static String intArray2String(int[] intArray) {
        return intArray2String(intArray, ",");
    }

    public static String intArray2String(int[] intArray, String sep) {
        return "[" + Arrays.stream(intArray).mapToObj(String::valueOf).collect(Collectors.joining(sep)) + "]";
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

    public static <O> String list2Str(List<O> list) {
        return "[" + list.stream().map(o -> o.toString()).collect(Collectors.joining(",")) + "]";
    }

    public static ListNode makeLinkedList(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            cur.next = node;
            cur = cur.next;
        }
        return head.next;
    }
}
