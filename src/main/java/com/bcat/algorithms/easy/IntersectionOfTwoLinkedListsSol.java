package com.bcat.algorithms.easy;

import com.bcat.domain.ListNode;
import com.bcat.utils.Utils;

/**
 * Solution for LeetCode algorithms 160-Intersection of Two Linked Lists.
 *
 * <p>Write a program to find the node at which the intersection of two singly
 * linked lists begins: begin to intersect at node c1.</p>
 * <p><b>Example 1: </b><pre>
 *     <b>Input: </b>intersectVal = 8, listA = [4,1,8,4,5], listB=[5,0,1,8,4,5],
 *            skipA = 2, skipB = 3
 *     <b>Output: </b>Reference of the node with value = 8
 *     <b>Input Explanation: </b>The intersected node's value is 8 (note that
 *           this must not be 0 if the two lists intersect). From the head of A,
 *           it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5].
 *           There are 2 nodes before the intersected node in A; There are 3 nodes
 *           before the intersected node in B.
 * </pre></p>
 * <p><b>Example 2: </b><pre>
 *    <b>Input: </b>intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 *    <b>Output: </b>Reference of the node with value = 2
 *    <b>Input Explanation: </b>The intersected node's value is 2 (note that this
 *           must not be 0 if the two lists intersect). From the head of A, it reads
 *           as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3
 *           nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * </pre></p>
 * <p><b>Example 3: </b><pre>
 *     <b>Input: </b>intersectVal = 2,  listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 *     <b>Output: </b>null
 *     <b>Input Explanation: </b>From the head of A, it reads as [2,6,4]. From the head of B,
 *           it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0,
 *           while skipA and skipB can be arbitrary values. Explanation: The two lists do not
 *           intersect, so return null.
 * </pre></p>
 * <p><b>Notes: </b><ul>
 * <li>If the two linked lists have no intersection at all, return {@code null}.</li>
 * <li>The linked lists must retain there original structure after the function returns.</li>
 * <li>You may assume there are no cycles anywhere in the entire linked structure.</li>
 * <li>Your code should preferably run in O(n) time and use only O(1) memory.</li>
 * </ul></p>
 *
 * <p><b>Solution: </b>
 * <p><b>1. 双指针</b><pre>
 * 如果两个队列的尾节点是同一个, 那么两个链表必然相交. 用两个指针, pA和pB, 分别遍历链表A
 * 和链表B, 当pA到达链表尾部(pA.next == null)时, pA指向链表B再次开始遍历; pB到达链表尾部
 * (pB.next == null)时, pB指向链表<b>A</b>再次遍历. 当pA和pB相遇时, 即是链表A和链表B
 * 相交的节点; 否则, 两个链表不相交. 其实, 这具就是利用两个指针来模拟两个链表的长度差, 遍历
 * 完成一个链表后, 指向另一个链表开始遍历, 那么, 第二次遍历就会体现出两个差.
 * </pre></p>
 * </p>
 *
 * @date 28/05/2020
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class IntersectionOfTwoLinkedListsSol {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        // 移动pA和pB到链表尾
        while (null != pA && null != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        if (null == pA) {
            pA = headB;
        }
        if (null == pB) {
            pB = headA;
        }
        // 继续移动, 直到两个指针相遇或两个指针到达null
        while (pA != null || pB != null) {
            if (null == pA) {
                pA = headB;
            } else if (null == pB) {
                pB = headA;
            }
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = Utils.makeLinkedList(new int[]{4, 1, 8, 4, 5});
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;
        System.out.println(getIntersectionNode(headA, headB).val);

        headA = new ListNode(8);
        headB = headA;
        System.out.println(getIntersectionNode(headA, headB).val);

        headA = new ListNode(0);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = new ListNode(2);
        headA.next.next.next.next = new ListNode(4);
        headB = new ListNode(3);
        headB.next = headA.next.next.next;
        System.out.println(getIntersectionNode(headA, headB).val);

        headA = new ListNode(2);
        headA.next = new ListNode(6);
        headA.next.next = new ListNode(4);
        headB = new ListNode(1);
        headB.next = new ListNode(5);
        System.out.println(getIntersectionNode(headA, headB));

        headA = new ListNode(0);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = new ListNode(2);
        headA.next.next.next.next = new ListNode(4);
        headB = headA.next.next;
        System.out.println(getIntersectionNode(headA, headB).val);

        headA = new ListNode(1);
        headB = null;
        System.out.println(getIntersectionNode(headA, headB));

        headA = new ListNode(3);
        headB = new ListNode(2);
        headB.next = headA;
        System.out.println(getIntersectionNode(headA, headB).val);
    }
}
