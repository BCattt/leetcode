package com.bcat.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

import com.bcat.domain.ListNode;

/**
 * Solution for LeetCode algorithm 234 - Palindrome Linked List.
 *
 * <p>Given a simple linked list, determine if it is a palindrome.</p>
 * <p><p><b>Example 1:</b><pre>
 *     <b>Input: </b>1->2
 *     <b>Output: </b> false
 * </pre></p>
 * <p><b>Example 2:</b><pre>
 *     <b>Input: </b>1->2->2->1
 *     <b>Output: </b>true
 * </pre></p>
 * </p>
 * <p><b>Follow up: </b>
 * Could you do it in O(n) time and O(1) space?
 * </p>
 * <p><b>Solution: </b>
 * <p><b>1. 正反向遍历</b><pre>
 *     如果一个链表是回文链表，则其以中间元素为中心对称，遍历一遍链表并保存遍历结果，看元素
 * 是否对称即可，
 * <b>时间复杂度: </b>O(n)
 * <b>空间复杂度: </b>O(n)
 * </pre></p>
 * <p><b>2. 递归</b></p>
 * 递归到底后开始从尾节点返回, 头节点指针则从头开始移动, 当头节点移动到尾部时, 遍历完成.
 * </p>
 *
 * @date 01/06/2020
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class PalindromeLinkedListSol {
    // Space -> O(n) Time -> O(n)
    public static boolean isPalindrome(ListNode head) {
        List<Integer> traverse = new ArrayList<>();
        while (null != head) {
            traverse.add(head.val);
            head = head.next;
        }
        for (int i = 0, j = traverse.size() - 1; i < j; ++i, --j) {
            if (!traverse.get(i).equals(traverse.get(j))) {
                return false;
            }
        }
        return true;
    }
    static void palindrome(ListNode node, ListNode head) {
        if (null == node || null == node.next) {
            return;
        }

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(null));

        ListNode head = new ListNode(1);
        System.out.println(isPalindrome(head));

        head.next = new ListNode(2);
        System.out.println(isPalindrome(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
