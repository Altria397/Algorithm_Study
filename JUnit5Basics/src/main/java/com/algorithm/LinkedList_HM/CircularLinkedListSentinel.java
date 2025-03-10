package com.algorithm.LinkedList_HM;

import java.util.Iterator;

public class CircularLinkedListSentinel implements Iterable<Integer>{
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    /**
     * 1 -> 2 -> 3 -> 1
     * 在双向环形链表中 哨兵既做头也作尾
     * 加哨兵 s -> 1 -> 2 -> 3 -> s
     */
    private static class Node{
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, -1, null);

    public CircularLinkedListSentinel() {
        //初始化哨兵，使哨兵的头指针和尾指针都指向自己
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * 添加到第一个
     * @param value-待添加的值
     */
    public void addFirst(int value){
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node (a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 添加到最后一个
     * @param value-待添加的值
     */
    public void addLast(int value){
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 删除第一个节点
     */
    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = sentinel;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    /**
     * 删除最后一个节点
     */
    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = sentinel;
        Node b = removed.prev;
        a.prev = b;
        b.next = a;
    }


    /**
     * 根据值查找节点
     * @param value 传入的值
     * @return 查找情况，null为不存在值为value的节点
     */
    private Node findByValue(int value) {
        Node cnt = sentinel.next;
        while (cnt != sentinel) {
            if (cnt.value == value)
                return cnt;
            cnt = cnt.next;
        }
        return null;
    }

    /**
     * 更具value删除节点
     * @param value 传入的值
     */
    public void removeByValue(int value) {
        Node removed = findByValue(value);
        if (removed == null) {
            throw new IllegalArgumentException("链表为空");
        } else {
            Node a = removed.next;
            Node b = removed.prev;
            a.prev = b;
            b.next = a;
        }
    }
}
