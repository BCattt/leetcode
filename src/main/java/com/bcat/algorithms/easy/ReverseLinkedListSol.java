package com.bcat.algorithms.easy;

import com.bcat.domain.ListNode;
import com.bcat.utils.Utils;

/**
 * Solution for LeetCode algorithms 206 - Reverse Linked List.
 *
 * <p>Reverse a singly linked list.</p>
 * <p><b>Example: </b><pre>
 *     <b>Input: </b>1->2->3->4->5->NULL
 *     <b>Output: </b>5->4->3->2->1->NULL
 * </pre></p>
 * <p><b>Follow up:</b>
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both ?
 * </p>
 *
 * <p><b>Solution</b><pre>
 * 1. 迭代法
 * 使用2个指针, prev指向前一个元素, cur指向当前元素, 在遍历过程中进行反转.
 * </pre></p>
 *
 * @date 01/06/2020
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class ReverseLinkedListSol {
    // 迭代
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // 递归
    public static ListNode reverseListR(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode node = reverseListR(head.next);
        node.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Utils.printLinkedList(reverseList(head));
        Utils.printLinkedList(reverseListR(head));
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Utils.printLinkedList(reverseList(head));
        Utils.printLinkedList(reverseList(null));
    }
}
