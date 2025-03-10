package com.structure.queue;

import com.structure.linked_node.ListNode;

public class LinkedListQueue {
    private ListNode front, rear; // 头节点 front ，尾节点 rear
    private int queSize = 0;

    public LinkedListQueue() {
        front = null;
        rear = null;
    }
    // 获取队列长度
    public int size() {
        return queSize;
    }
    // 判断是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(int num) {
        ListNode node = new ListNode(num);
        if (front == null) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }
}
