package com.bcat.algorithms.easy;

/**
 * Solution for LeetCode problem 21. Merge Two sorted Lists
 * <p>
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * <b>Example:</b>
 * {@code
 *   Input: 1->2->4, 1->3->4
 *   Output: 1->1->2->3->4->4
 * }
 * 有序链表归并
 */
public class MergeTwoSortedListsSol {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 制造一个头节点
        ListNode head = new ListNode(0);
        ListNode curNode = head;
        while (l1 != null || l2 != null) {
            if (null != l1 && l2 != null) {
                if (l1.val > l2.val) {
                    curNode.next = l2;
                    curNode = l2;
                    l2 = l2.next;
                } else {
                    curNode.next = l1;
                    curNode = l1;
                    l1 = l1.next;
                }
            } else if (l1 != null) {
                curNode.next = l1;
                break;
            } else if (l2 != null) {
                curNode.next = l2;
                break;
            }
        }
        return head.next;
    }

    public static void print(ListNode l) {
        while (null != l) {
            System.out.print(l.val + " -> ");
            l = l.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);
        print(result);

        l1 = new ListNode(1);
        l2 = null;
        print(mergeTwoLists(l1, l2));

        l1 = null;
        l2 = new ListNode(1);;
        print(mergeTwoLists(l1, l2));

        l1 = new ListNode(1);
        l2 = new ListNode(1);;
        print(mergeTwoLists(l1, l2));
    }
}
