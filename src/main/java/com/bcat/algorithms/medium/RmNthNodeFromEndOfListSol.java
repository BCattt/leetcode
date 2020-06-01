package com.bcat.algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bcat.domain.ListNode;

/**
 * Solution for LeetCode problem 19. Remove Nth Node From End of List
 *
 * Given a single linked list, remove the n-th node from the end of list and return its head.
 *
 * <b>Example: </b>
 * {@code
 *   Given linked list: 1->2->3->4->5, and n = 2
 *   After removing the second node from the end, the linked list becomes 1->2->3->5.
 * }
 * <b>Note:</b>
 * Given <i>n</i> will always be valid.
 *
 * <b>Follow up:</b>
 * Could you do this in one pass?
 *
 * 解题思路：
 *   题目要求1次遍历完成删除。
 * 思路1:
 *   设置2个指针start指针和end指针，距离为n，同时向后移动start和end，当end移动到null时，start所指向的位置即为要删除节点的位置
 *   。如此，一次遍历完成节点删除。
 *   由于是单链表，需要记录start指针的前一个节点位置preStart。初始时，preStart, start和end指向链表头head。
 *   end向后移动n个位置后，开始同步移动start和preStart。
 * 思路2:
 *       设置2个指针start和end，距离设置n+1，同时向后移动start和end，当end移动至null时，
 *   start所指向的位置即为要删除节点的前一个节点位置。
 *
 */
public class RmNthNodeFromEndOfListSol {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preStart = null, start = head, end = head;
        // end指针向后移动n个位置(由于n是有效的, 此时end必然有效)
        for (int move = 0; move < n - 1; ++move) {
            end = end.next;
        }
        // 如果end后面还有元素，则同步移动start和end一个位置，以便使preStart指向有效位置
        if (null != end) {
            preStart = head;
            start = start.next;
            end = end.next;
        } else {
            // end后面没有元素了，表示要删除第一个节点，直接返回head.next即可
            return head.next;
        }
        // 继续向后移动end指针，直到链表结束
        while(null != end) {
            preStart = preStart.next;
            start = start.next;
            end = end.next;
        }
        // 移动到正确位置，将preStart指针的next指针指向start的next，删除start节点
        preStart.next = start.next;
        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode start = head, end = head;
        // 先向后移动n个位置
        for (int move = 1; move <= n; ++move) {
            end = end.next;
        }
        if (null == end) {
            return head.next;
        } else {
            // 再向后移动一个位置
            end = end.next;
        }
        while (null != end) {
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
        System.out.println("Original");
        printLinkedList(head);
        int removePos = 5;
        ListNode deleted = removeNthFromEnd2(head, removePos);
        System.out.println("removeNthFromEnd(head, " + removePos + "): ");
        printLinkedList(deleted);
    }

    public static void printLinkedList(ListNode head) {
        List<Integer> values = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            values.add(node.val);
        }
        System.out.println(values.stream().map(String::valueOf).collect(Collectors.joining("->")));
    }
}
