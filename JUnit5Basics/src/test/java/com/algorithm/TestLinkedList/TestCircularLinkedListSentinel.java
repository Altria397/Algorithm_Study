package com.algorithm.TestLinkedList;

import com.algorithm.LinkedList_HM.CircularLinkedListSentinel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestCircularLinkedListSentinel {
    @Test
    @DisplayName("测试添加头部")
    public void test1(){
        CircularLinkedListSentinel list = new CircularLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        for (Integer value : list){
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("测试添加尾部")
    public void test2(){
        CircularLinkedListSentinel list = new CircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        for (Integer value : list){
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("测试删除头节点和尾节点")
    public void test3(){
        CircularLinkedListSentinel list = new CircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.removeFirst();
        list.removeLast();
        for (Integer value : list){
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("测试根据值删除")
    public void test4(){
        CircularLinkedListSentinel list = new CircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.removeByValue(3);
        for (Integer value : list){
            System.out.println(value);
        }
    }
}
