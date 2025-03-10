package com.algorithm.TestList;

import com.structure.list.MyList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyListTest {

    @Test
    void testSize() {
        MyList myList = new MyList();
        assertEquals(0, myList.size()); // 初始列表大小应为0

        myList.add(1);
        myList.add(2);
        myList.add(3);
        assertEquals(3, myList.size()); // 添加元素后，列表大小应为3
    }

    @Test
    void testGetCapacity() {
        MyList myList = new MyList();
        assertEquals(10, myList.getCapacity()); // 初始列表容量应为10

        myList.add(1);
        myList.add(2);
        myList.add(3);
        assertEquals(10, myList.getCapacity()); // 容量未达到扩容条件，容量应为10

        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(10);
        myList.add(11);
        myList.add(12);
        myList.add(13);
        myList.add(14);
        assertEquals(20, myList.getCapacity()); // 容量达到扩容条件，容量应为20
    }

    @Test
    void testGet() {
        MyList myList = new MyList();
        myList.add(1);
        myList.add(2);
        myList.add(3);

        assertEquals(1, myList.get(0)); // 获取索引0处的元素，应为1
        assertEquals(2, myList.get(1)); // 获取索引1处的元素，应为2
        assertEquals(3, myList.get(2)); // 获取索引2处的元素，应为3

        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.get(3); // 索引越界，应抛出异常
        });
    }

    @Test
    void testSet() {
        MyList myList = new MyList();
        myList.add(1);
        myList.add(2);
        myList.add(3);

        myList.set(1, 4);
        assertEquals(4, myList.get(1)); // 更新索引1处的元素为4，应获取4

        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.set(3, 5); // 索引越界，应抛出异常
        });
    }

    @Test
    void testAdd() {
        MyList myList = new MyList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        assertEquals(3, myList.size()); // 列表大小应为3

        myList.add(4);
        myList.add(5);
        myList.add(6);
        assertEquals(6, myList.size()); // 列表大小应为6
    }

    @Test
    void testInsert() {
        MyList myList = new MyList();
        myList.add(1);
        myList.add(3);
        myList.add(4);

        myList.insert(1, 2);
        assertEquals(2, myList.get(1)); // 在索引1处插入元素2，应获取2
        assertEquals(4, myList.size()); // 列表大小应为4

        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.insert(6, 5); // 索引越界，应抛出异常
        });
    }

    @Test
    void testRemove() {
        MyList myList = new MyList();
        myList.add(1);
        myList.add(2);
        myList.add(3);

        assertEquals(1, myList.remove(0)); // 删除索引0处的元素，应返回1
        assertEquals(2, myList.size()); // 列表大小应为2

        assertEquals(3, myList.remove(1)); // 删除索引1处的元素，应返回3
        assertEquals(1, myList.size()); // 列表大小应为1

        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.remove(1); // 索引越界，应抛出异常
        });
    }

    @Test
    void testToArray() {
        MyList myList = new MyList();
        myList.add(1);
        myList.add(2);
        myList.add(3);

        int[] array = myList.toArray();
        assertArrayEquals(new int[]{1, 2, 3}, array); // 列表元素应与数组元素相同
    }
}

