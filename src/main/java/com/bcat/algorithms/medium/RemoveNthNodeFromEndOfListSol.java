package com.bcat.algorithms.medium;

import com.bcat.domain.ListNode;
import com.bcat.utils.Utils;

/**
 * Solution for LeetCode algorithms 19-Remove Nth Node From End of List.
 *
 * <p>Given a linked list, remove the n-th node from the end of list and return
 * its head.</p>
 * <p><b>Example: </b><pre>
 *     Given liked list: 1->2->3->4->5, and n = 2.
 *     After removing the second node from the end, the linked list becomes
 *     1->2->3->5.
 * </pre></p>
 * <p><b>Note: </b>Given n will always be valid.</p>
 * <p><b>Follow up: </b>Could you do this in one pass?</p>
 *
 * <p><b>Solution: </b>
 * <p><b>1. 双指针</b><pre>
 *     使用2个指针{@code front}和{@code end}; 待{@code end}移动{@code n + 1}个位置后,
 * 开始同时移动{@code front}和{@code end}指针. 当{@code end}指针移动到链表尾时,
 * {@code front}指针即指向要删除节点的前一个节点.
 * </pre></p>
 * </p>
 */
public class RemoveNthNodeFromEndOfListSol {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head, end = head;
        // end指针向后移动n + 1个位置
        while (n > 0 && end != null) {
            end = end.next;
            --n;
        }
        // 开始同时移动front和end
        while (null != end && null != end.next) {
            front = front.next;
            end = end.next;
        }
        // end到了队尾, 则表示要删除头节点
        if (null == end) {
            head = head.next;
        } else {
            // 删除front后一个节点
            front.next = front.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        Utils.printLinkedList(removeNthFromEnd(head, 2));

        head = new ListNode(1);
        Utils.printLinkedList(removeNthFromEnd(head, 1));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Utils.printLinkedList(removeNthFromEnd(head, 2));
    }
}
