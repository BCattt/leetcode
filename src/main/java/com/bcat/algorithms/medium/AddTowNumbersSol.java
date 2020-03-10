package com.bcat.algorithms.medium;

/**
 * Problem #2 Add Two Numbers solution
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * <b>Example:</b>
 * {@literal
 *
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * }
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class AddTowNumbersSol {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    public static ListNode addTowNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode sumNode = new ListNode(0);
        ListNode cur = sumNode;
        int cur1Val, cur2Val, sum, carry = 0;
        while (null != cur1 || null != cur2) {
            // 如果节点为空，则其值为0
            cur1Val = null == cur1 ? 0 : cur1.val;
            cur2Val = null == cur2 ? 0 : cur2.val;
            // 计算当前节点的和
            sum = cur1Val + cur2Val + carry;
            // 进位
            carry = sum / 10;
            // 创建当前节点
            cur.next = new ListNode(sum % 10);
            // 向前移动当前节点
            cur = cur.next;
            cur.next = null;

            if (null != cur1) {
                cur1 = cur1.next;
            }
            if (null != cur2) {
                cur2 = cur2.next;
            }
        }
        // 最后一位如果需要进位，则进位
        if (carry > 0) {
            cur.next = new ListNode(carry);
            cur = cur.next;
            cur.next = null;
        }
        return sumNode.next;
    }

    public static void main(String[] args) {
        ListNode num1 = new ListNode(2);
        num1.next = new ListNode(4);
        num1.next.next = new ListNode(3);

        ListNode num2 = new ListNode(5);
        num2.next = new ListNode(6);
        num2.next.next = new ListNode(7);

        ListNode sum = addTowNumbers(num1, num2);

        while (null != sum) {
            System.out.print(sum.val + " -> ");
            sum = sum.next;
        }
        System.out.println();
        num1 = new ListNode(0);
        num2 = new ListNode(0);
        sum = addTowNumbers(num1, num2);
        while (null != sum) {
            System.out.print(sum.val + " -> ");
            sum = sum.next;
        }
    }
}
