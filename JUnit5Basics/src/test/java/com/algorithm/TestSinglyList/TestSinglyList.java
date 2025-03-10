package com.algorithm.TestSinglyList;

import com.algorithm.LinkedList_HM.Sentinel.SinglyLinkedListSentinel;
import com.algorithm.LinkedList_HM.SinglyLinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class TestSinglyList {

    @Test
    @DisplayName("单向链表添加和遍历测试")
    public void test1(){
        SinglyLinkedList singlyLinkedList =  new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);

        singlyLinkedList.loop1(value->{
            System.out.println(value);
        });

        singlyLinkedList.loop2(value->{
            System.out.println(value);
        });
    }

    @Test
    @DisplayName("迭代器遍历")
    public void test2(){
        SinglyLinkedList singlyLinkedList =  new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);

        for (Integer i : singlyLinkedList) {
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("尾插法")
    public void test3(){
        SinglyLinkedList singlyLinkedList =  new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        for (Integer i : singlyLinkedList) {
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("按索引查找测试")
    public void test4(){
        SinglyLinkedList singlyLinkedList =  new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        int i = singlyLinkedList.getNodeValue(3);
        System.out.println(i);
        int i2= singlyLinkedList.getNodeValue(4);
        System.out.println(i2);
    }

    @Test
    @DisplayName("按索引添加测试")
    public void test5(){
        SinglyLinkedList list =  new SinglyLinkedList();
        list.Insert(0,1);
        list.Insert(0,2);
        list.Insert(1,3);
        list.Insert(1,4);

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("删除头节点测试")
    public void test6(){
        SinglyLinkedList singlyLinkedList =  new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        singlyLinkedList.removeFirst();
        for (Integer integer : singlyLinkedList) {
            System.out.println(integer);
        }
    }

    @Test
    @DisplayName("删除任意位置节点测试")
    public void test7() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        singlyLinkedList.remove(1);
        for (Integer integer : singlyLinkedList) {
            System.out.println(integer);
        }
    }

    @Test
    @DisplayName("带哨兵链表的添加测试")
    public void test8(){
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.loop1(value ->{
            System.out.println(value);
        });

        list.loop2(value ->{
            System.out.println(value);
        });

        for (Integer integer : list){
            System.out.println(integer);
        }
    }

    @Test
    @DisplayName("带哨兵链表的添加测试")
    public void test9(){
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        System.out.println(list.getNodeValue(2));
        System.out.println(list.getNodeValue(5)); //不合法位置测试
    }

    @Test
    @DisplayName("带哨兵链表的添加测试")
    public void test10(){
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.Insert(0,5);
        //任意位置插入
        list = getLinkedList();
        list.Insert(4,5);
        //非空链表 添加头节点
        list = getLinkedList();
        list.addFirst(5);

        //空链表添加
        list = new SinglyLinkedListSentinel();
        list.addFirst(1);
        list.loop1(value->{
            System.out.println(value);
        });
    }

    @Test
    @DisplayName("带哨兵链表的删除测试")
    public void test11(){
        SinglyLinkedListSentinel list = getLinkedList();
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.loop1(value->{
            System.out.println(value);
        });
    }

    @Test
    @DisplayName("递归调用遍历链表")
    public void test12(){
        SinglyLinkedList list =  new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.loop3();
    }

    private SinglyLinkedListSentinel getLinkedList(){
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        return list;
    }
}
