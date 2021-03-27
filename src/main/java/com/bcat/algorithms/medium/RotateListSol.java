package com.bcat.algorithms.medium;

import com.bcat.domain.ListNode;
import com.bcat.utils.Utils;

public class RotateListSol {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        int n = 0;
        ListNode prev = null;
        while (node != null) {
            prev = node;
            node = node.next;
            ++n;
        }
        int realPos = k % n;

        if (realPos != 0) {
            realPos = n - realPos;
        }

        // 联通首尾
        prev.next = head;

        node = head;
        while (realPos > 0) {
            prev = node;
            node = node.next;
            --realPos;
        }
        prev.next = null;

        return node;
    }

    public static void main(String[] args) {
        ListNode head = null;
        head = constructLinkedList();
        RotateListSol sol = new RotateListSol();
        System.out.println(Utils.linkedList2String(sol.rotateRight(head, 0)));
        head = constructLinkedList();
        System.out.println(Utils.linkedList2String(sol.rotateRight(head, 1)));
        head = constructLinkedList();
        System.out.println(Utils.linkedList2String(sol.rotateRight(head, 2)));
        head = constructLinkedList();
        System.out.println(Utils.linkedList2String(sol.rotateRight(head, 3)));
        head = constructLinkedList();
        System.out.println(Utils.linkedList2String(sol.rotateRight(head, 4)));
        head = constructLinkedList();
        System.out.println(Utils.linkedList2String(sol.rotateRight(head, 5)));
        head = constructLinkedList();
        System.out.println(Utils.linkedList2String(sol.rotateRight(head, 6)));

        head = new ListNode(1);
        System.out.println(Utils.linkedList2String(sol.rotateRight(head, 2)));
    }

    private static ListNode constructLinkedList() {
        ListNode head;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }

}
