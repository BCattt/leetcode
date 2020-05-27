package com.bcat.algorithms.easy;

import java.util.HashSet;

/**
 * Solution for Leetcode algorithm 141 - Linked List Cycle.
 *
 * <p>Given a linked list, determine if it has a cycle in it.</p>
 * <p>To represent a cycle in the given linked list, we use an integer {@code pos}
 * which represents the position (0-indexed) in the linked list where tail
 * connects to. If {@code pos} is {@code -1}, then there is no cycle in the linked
 * list.</p>
 * <p><b>Example 1: </b><pre>
 *     <b>Input: </b>head = [3,2,0,-4], pos = 1
 *     <b>Output: </b>true
 *     <b>Explanation: </b>These is a cycle in the linked list, where tail connects
 *                  to the second node.
 *     3 -> 2 -> 0 -> 4 --+
 *         /|\            |
 *          |             |
 *          +-------------+
 * </pre></p>
 * <p><b>Example 2: </b><pre>
 *     <b>Input: </b>head = [1,2], pos = 0
 *     <b>Output: </b>true
 *     <b>Explanation: </b> There is a cycle in the linked list, where tail
 *                   connects to the first node.
 * </pre></p>
 * <p><b>Example 3: </b><pre>
 *     <b>Input: </b>head = [1], pos = -1
 *     <b>Output: </b>false
 *     <b>Explanation: </b>These is no cycle in the linked list.
 * </pre></p>
 * <p><b>Follow up: </b>
 * Can you solve it using O(1) (i.e. constant) memory ?
 * </p>
 * <p></p>
 * <p><b>Solution: </b>
 * <p><b>1. 空换时</b><pre>
 *     使用一个HashSet记录每个访问过的节点, 访问过程中, 一旦发现相同的节点重复访问, 则存在
 * 环, 否则不存在环.
 * <b>时间复杂度: </b>O(n)
 * <b>空间复杂度: </b>O(n)
 * </pre></p>
 * <p><b>2. 快慢指针</b><pre>
 *     使用两个指针, 慢指针一次向后移动1个位置; 快指针一次向后移动2个位置; 如果有环, 则
 * 快慢指针最终会相遇, 而如果没有环, 则最终快指针先到达尾(null).
 * </pre></p>
 * </p>
 */
public class LinkedListCycleSol {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 使用一个HashSet记录已访问过的节点.
     */
    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        while (null != head) {
            if (visited.contains(head)) {
                return true;
            } else {
                visited.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 使用快慢指针, 快指针一次移动2个位置, 慢指针一次移动1个位置. 两个指针相遇, 说明有环;
     * 快指针先到达(null), 说明没有环.
     */
    public static boolean hasCycle2(ListNode head) {
        ListNode slowP = head;
        ListNode fastP = head;
        // 开始移动
        while (null != fastP) {
            // 慢指针移动1个位置
            slowP = slowP.next;
            // 快指针移动2个位置
            fastP = fastP.next;
            if (null != fastP) {
                fastP = fastP.next;
            } else {
                return false;
            }
            // 如果2个指针相遇, 则说明有环
            if (slowP == fastP) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next  = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        // true
        System.out.println(hasCycle(head));
        System.out.println(hasCycle2(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        // true
        System.out.println(hasCycle(head));
        System.out.println(hasCycle2(head));

        head = new ListNode(1);
        // false
        System.out.println(hasCycle(head));
        System.out.println(hasCycle2(head));

        head = new ListNode(1);
        head.next = head;
        // true
        System.out.println(hasCycle(head));
        System.out.println(hasCycle2(head));
    }
}
