package com.bcat.algorithms.hard;

import com.bcat.domain.ListNode;
import com.bcat.utils.Utils;

/**
 * Solution for LeetCode Problem 23-Merge k Sorted Lists.
 *
 * <p>Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * <p><b>Example:</b>
 * {@code
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * }
 *
 * <p>解题思路:
 * 循环遍历k个链表，每次取最小元素，将当前指针指向它，然后将当前结果节点指向此节点。
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class MergekSortedListsSol {

    public static ListNode mergeKLists(ListNode[] lists) {
        // 虚拟头节点，用于记录返回头
        ListNode dummyHead = new ListNode(0);
        // 当前结果节点
        ListNode  curResultNode = dummyHead;
        // 当前节点行指向第一个链表的第一个节点
        ListNode curNode = null;
        // 是否仍然有节点需要merge
        boolean mergeCompleted;
        // 当前最小节点所在的链表
        int curIdx = 0;
        do {
            mergeCompleted = true;
            for (int i = 0; i < lists.length; ++i) {
                // 当前链表仍然有值
                if (null != lists[i]) {
                    // 只要有一个节点不为null，就表示合并未完成
                    mergeCompleted = false;
                    // 如果当前节点指向一个链表尾，则代表最大值，直接将其指向当前链表
                    if (null == curNode) {
                        curNode = lists[i];
                        curIdx = i;
                    // 当前节点的值大于当前链表值，则切换到当前链表
                    } else if (curNode.val > lists[i].val) {
                        curNode = lists[i];
                        curIdx = i;
                    }
                }
            }
            if (!mergeCompleted) {
                // 一次循环后，找到了当前最小节点，当前结果节点的next指向当前节点
                // 然后向后移动当前结果节点
                // 同时，将当前结点置到当前链表的下一个节点
                curResultNode.next = curNode;
                curResultNode = curNode;
                lists[curIdx] = lists[curIdx].next;
                curNode = curNode.next;
            }
        } while (!mergeCompleted);
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};
        Utils.printList(mergeKLists(lists));
    }
}
