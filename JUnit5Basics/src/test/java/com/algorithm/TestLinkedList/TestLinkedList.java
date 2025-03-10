package com.algorithm.TestLinkedList;
import com.algorithm.LinkedList.LinkedList;
import com.algorithm.LinkedList.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class TestLinkedList {
    @Test
    @DisplayName("链表测试")
    public void test1(){
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        LinkedList list = new LinkedList();
        Node newNode = list.createLinkedList(array);
        list.showLinkedList(newNode);
    }

    @Test
    @DisplayName("链表测试")
    public void test2(){
        int[] array = {0, 1, 2, 3, 4, 5, 6, 9};
        LinkedList list = new LinkedList();
        Node newNode = list.createLinkedList(array);
        list.showLinkedList(newNode);

        list.addIntoHead(newNode, 888);
        list.addNode(newNode, 999, 7);
        list.addIntoTail(newNode, 777);
        list.showLinkedList(newNode);
    }

    @Test
    @DisplayName("链表删除测试")
    public void test3(){
        int[] array = {0, 1, 2, 3, 4, 5, 6, 9};
        LinkedList list = new LinkedList();
        Node newNode = list.createLinkedList(array);
        //list.showLinkedList(newNode);
        //System.out.println(newNode.value);
        list.deleteNode(newNode, 10);
        list.showLinkedList(newNode);
    }


    @Test
    @DisplayName("查询特定值在链表中的位置")
    public void test4(){
        int[] array = {0, 1, 2, 3, 4, 5, 6, 9};
        LinkedList list = new LinkedList();
        Node newNode = list.createLinkedList(array);
        //list.showLinkedList(newNode);
        System.out.println(list.SearchValue(newNode, 8));
        System.out.println(list.SearchValue(newNode, 9));
        System.out.println(list.SearchValue(newNode, 0));
//        list.addIntoHead(newNode, 888);
//        list.addNode(newNode, 999, 7);
//        list.addIntoTail(newNode, 777);
//        list.showLinkedList(newNode);
    }

    @Test
    @DisplayName("带哨兵链表的添加测试")
    public void test5(){

    }
}
