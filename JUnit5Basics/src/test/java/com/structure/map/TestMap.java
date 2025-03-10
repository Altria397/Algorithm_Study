package com.structure.map;

/*
   Description: 测试数组集合
   Author: 叁玖柒
   Date: 2025/1/16
   Time: 10:36
*/
public class TestMap {
    public static void main(String[] args) {
        ArrayHashMap map = new ArrayHashMap();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(31, "d");
        map.put(101, "e");

        map.print();
    }
}
