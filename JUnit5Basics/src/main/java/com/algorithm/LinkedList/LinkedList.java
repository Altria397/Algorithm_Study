package com.algorithm.LinkedList;
import com.algorithm.LinkedList.Node;

public class LinkedList {
    public Node createLinkedList (int[] array) {
        Node head = new Node();
        Node tail = null;

        Node node = null;
        for (int i = 0; i < array.length; i++) {
            node = new Node(array[i]);
            if (i == 0) {
                head.next = node;
            }else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    public void showLinkedList (Node head) {
        if (head == null || head.next == null) {
            System.out.println("这是空链表");
            return;
        }
        Node node = head.next;
        do {
            System.out.println(node.value);
            node = node.next;
        }while (node != null);
    }

    public void addIntoHead(Node list, int value){
        Node newNode = new Node(value);
        //头部添加，将头部的next赋给new的next，将新节点给头的next
        newNode.next = list.next;
        list.next = newNode;
    }

    public void addNode (Node list, int value, int index){
        Node newNode = new Node(value);

        //中间位置添加，先找到index个节点，将index节点的next给新节点的next，将新节点给index节点的next
        newNode = new Node(value);
        Node node = list.next; //node最终是第index个节点
        for (int i = 0; i <= index; i++){
            node = node.next; //后移指向，移向下一个节点
        }
        newNode.next = node.next;
        node.next = newNode;
    }

    public void addIntoTail(Node list, int value) {
        Node newNode = new Node(value);
        //在尾部添加，找到next为null的节点，将新节点添加到next中
        Node node = list.next;
        while (node.next != null) {
            node = node.next; //后移
        }
        node.next = newNode;
    }

    //删除节点，删除链表中第一个value节点
    public void deleteNode(Node list, int value){
        Node node = list;
        //System.out.println(node.next.value);
        //遍历整个链表，当满足下面列条件
        while (node != null && node.next != null && node.next.value != value){
            node = node.next;
        }

        //所有节点遍历完成，未发现目标元素
        if (node == null || node.next==null){
            //此时代表未找到值为value的结点
            //return;
            System.out.println("未找到该值的节点");
            return ;
        }

        Node toDelete = node.next;
        node.next=toDelete.next;
    }

    //查找节点，查找链表中第一个value节点的索引
    public int SearchValue (Node list, int target) {
        Node newNode = list;
        int index = 0;
        while (newNode != null){
            if (newNode.value == target){
                return index;
            }
            newNode = newNode.next;
            index++;
        }
        //没查到的情况
        return -1;
    }
}
