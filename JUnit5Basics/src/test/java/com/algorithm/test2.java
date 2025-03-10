package com.algorithm;

import java.util.List;

/**
 * @program: Algorithm_Study
 * @description:
 * @author: Altria397
 * @create: 2023-09-21 19:30
 */

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class test2 {
    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        new ListNode(4, node);
        new ListNode(3, node);
        new ListNode(2, node);
        new ListNode(1, node);
        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node);

        System.out.println(reverseList(node));
    }

    public static void op(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
        System.out.println(y);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode ans = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = ans;
            ans = cur;
            cur = next;
        }
        return ans;
    }
}
