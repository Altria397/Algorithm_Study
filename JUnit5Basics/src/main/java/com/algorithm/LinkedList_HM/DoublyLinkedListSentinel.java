package com.algorithm.LinkedList_HM;

import java.util.Iterator;

public class DoublyLinkedListSentinel implements Iterable<Integer>{
    static class Node {
        Node prev; //上一个指针
        int value; //值
        Node next; //下一个指针

        public Node (Node prev, int value, Node next){
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head; //头哨兵
    private Node tail; //尾哨兵

    public DoublyLinkedListSentinel(){
        head = new Node(null, 666, null);
        tail = new Node(null, 888,null);
        head.next = tail;
        tail.prev = head;
    }

    public Node findNode(int index){
        int i = -1; //从头哨兵开始
        for (Node p = head; p != tail; p = p.next, i++){
            if (i == index){
                return p;
            }
        }
        return null;
    }

    /**
     * 头插法
     * @param value-插入值
     */
    public void addFirst(int value){
        insert(0, value);
    }

    /**
     * 尾插法
     * @param value-插入值
     */
    public void addLast(int value){
        Node last = tail.prev;
        Node added = new Node(last, value,tail);
        last.next = added;
        tail.prev = added;
    }

    /**
     * 任意位置插入
     * @param index-插入的索引位置
     * @param value-插入的值
     */
    public void insert(int index, int value){
        Node prev = findNode(index - 1);
        if(prev == null){
            ThrowIllegal(index);
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        //将新节点放到prev和prev.next中间
        prev.next = inserted;
        next.prev = inserted;
    }

    /**
     * 抛出异常的索引位置
     * @param index-索引位置
     */
    private static void ThrowIllegal(int index) {
        throw new IllegalArgumentException
                (String.format("index [%d] 超出链表范围", index));
    }

    /**
     * 头部删除
     */
    public void removeFirst(){
        remove(0);
    }

    /**
     * 尾部删除
     */
    public void removeLast(){
        Node removed = tail.prev;
        if (removed == head){
            ThrowIllegal(0);
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    public void remove(int index){
        Node prev = findNode(index - 1);
        if (prev == null){
            ThrowIllegal(index);
        }
        Node removed = prev.next;
        if (removed == tail) {
            ThrowIllegal(index);
        }
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     * 迭代器遍历
     * @return 节点值
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
            }
            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
