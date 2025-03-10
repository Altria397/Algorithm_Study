package com.structure.linked_node;

/* 链表节点类 */
public class ListNode {
    public int val;        // 节点值
    public ListNode next;  // 指向下一节点的引用
    public ListNode(int x) { val = x; }  // 构造函数

    /* 在链表的节点 n0 之后插入节点 P */
    public void insert(ListNode n0, ListNode P) {
        ListNode n1 = n0.next;
        P.next = n1;
        n0.next = P;
    }

    /* 删除链表的节点 n0 之后的首个节点 */
    public void remove(ListNode n0) {
        if (n0.next == null)
            return;
        // n0 -> P -> n1
        ListNode P = n0.next;
        ListNode n1 = P.next;
        n0.next = n1;
    }
}
