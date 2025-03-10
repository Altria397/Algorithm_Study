package com.algorithm.LinkedList_HM.Sentinel;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 带哨兵的单向链表
 */
public class SinglyLinkedListSentinel implements Iterable<Integer>{
    private Node head = new Node(1000,null); //哨兵节点

    @Override
    public Iterator<Integer> iterator() {
            return new NodeIterator();
            }

    private class NodeIterator implements Iterator<Integer> {
        Node p = head.next;

        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public Integer next() {
            int val = p.value;
            p = p.next;
            return val;
        }
    }

/**
 * 关于内部类是否加static 应该分析当前内部类是否引用了外部类的变量，如Node类，该类中的所有变量都是自身定义的，不需要依靠外部类
 * 在上面iterator方法中，将原本的return部分的匿名内部类重新定义成了一个NodeIterator有名内部类
 * 但是由于他引用了外部类（singlyLinkedList）的变量head，所以他不能加static修饰
 */

/**
 * 节点类
 * 把Node类定义在SinglyLinkedList中，那么这个Node就是内部类
 * 对外可以隐藏实现细节
 */
    private static class Node{
        int value;
        Node next;

        public Node(){}

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表头部添加
     * @param value-插入值
     */
    public void addFirst(int value){
        //1.链表为空 2的代码可以满足1的情况
        //head = new Node(value, null);
        //2.链表非空
        Insert(0,value);
    }

    /**
     * 遍历链表
     */
    public void loop1(Consumer<Integer> consumer){
        Node p = head.next;
        while (p != null) {
            //System.out.println(p.value);
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer){
        Node p = head.next;
        for (; p != null; p = p.next){
            consumer.accept(p.value);
        }
    }

    /**
     * 找到最后一个指针
     * @return 最后一个节点
     */
    private Node findLast() {
        //一开始会返回哨兵节点
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    /**
     * 尾插法
     * @param value --要添加的值
     */
    public void addLast(int value){
        Node last = findLast();
        //带哨兵节点后，链表永远不为空，无论如何都会存在一个哨兵节点
        last.next = new Node(value, null);
    }

    /**
     * 根据索引查找节点元素
     * @param index--目标索引
     * @return p--查找到目标元素
     *          null--未找到
     */
    private Node findNode(int index) {
        Node p = head;//head节点是哨兵节点
        //定义i从-1开始，是让哨兵节点的索引为-1
        for (int i = -1; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public int getNodeValue(int index){
        Node p = findNode(index);
        if (p == null){
            ThrowIllegal(index);
        }
        return p.value;
    }

    private static void ThrowIllegal(int index) {
        throw new IllegalArgumentException
                (String.format("index [%d] 超出链表范围", index));
    }

    /**
     * 在任意索引位置添加新节点
     * @param index--索引位置
     * @param value--节点值
     */
    public void Insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null){ // index超出链表范围
            ThrowIllegal(index);
        }
        prev.next = new Node(value, prev.next);
    }

    /**
     * 删除第一节点
     */
    public void removeFirst(){
        remove(0);
    }

    public void remove (int index) {
        Node prev = findNode(index - 1); //找到上一个节点
        if (prev == null) {
            ThrowIllegal(index);
        }
        Node removed = prev.next;
        if (removed == null){ //被删除的索引位置不存在节点
            ThrowIllegal(index);
        }
        prev.next = removed.next;
    }
}
