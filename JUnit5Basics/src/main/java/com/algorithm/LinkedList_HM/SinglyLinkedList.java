package com.algorithm.LinkedList_HM;

import com.algorithm.LinkedList_HM.Sentinel.SinglyLinkedListSentinel;

import java.util.Iterator;
import java.util.function.Consumer;


public class SinglyLinkedList implements Iterable<Integer>{
    private Node head = null; //头节点

    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<Integer> {
        Node p = head;

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
     * 把Node类定义在SinglyLinkedListSentinel中，那么这个Node就是内部类
     * 对外可以隐藏实现细节
     */
    static class Node{
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
     * @param value
     */
    public void addFirst(int value){
        //1.链表为空 2的代码可以满足1的情况
        //head = new Node(value, null);
        //2.链表非空
        head = new Node(value, head);
    }

    /**
     * 遍历链表
     */
    public void loop1(Consumer<Integer> consumer){
        Node p = head;
        while (p != null) {
            //System.out.println(p.value);
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer){
        Node p = head;
        for (; p != null; p = p.next){
            consumer.accept(p.value);
        }
    }

    public void loop3() {
        recursion(head);
    }

    private void recursion(Node cur) {
        if (cur == null) {
            return;
        }else {
            System.out.println(cur.value);
            recursion(cur.next);
        }
    }

    /**
     * 找到最后一个指针
     * @return 最后一个节点
     */
    private Node findLast() {
        if (head == null) { //空链表
            return null;
        }
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
        if (last == null) {
            addFirst(value);
            return ;
        }
        last.next = new Node(value, null);
    }

    /**
     * 根据索引查找节点元素
     * @param index--目标索引
     * @return p--查找到目标元素
     *          null--未找到
     */
    private Node findNode(int index) {
        Node p = head;
        for (int i = 0; p != null; p = p.next, i++) {
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
        if (index == 0) {
            addFirst(value);
            return ;
        }
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
        if(head == null){
            ThrowIllegal(0);
        }
        head = head.next;
    }

    public void remove (int index) {
        if (index == 0){
            removeFirst();
            return ;
        }
        Node prev = findNode(index - 1);
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





