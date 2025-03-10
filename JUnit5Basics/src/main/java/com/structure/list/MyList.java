package com.structure.list;

import java.util.Arrays;
import java.util.stream.Stream;

public class MyList {
    private int[] arr;              // 初始化数组
    private int capacity = 10;      // 列表容量
    private int size = 0;           // 列表大小
    private int extendRatio = 2;    // 每次列表扩容的倍数

    /* 构造函数 */
    public MyList() {
        this.arr = new int[capacity];
    }

    public int size() {
        return size;
    }

    /* 获取列表容量 */
    public int getCapacity() {
        return capacity;
    }

    /* 获取指定索引的元素 */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        return arr[index];
    }

    /* 更新特定索引的元素 */
    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        arr[index] = value;
    }

    /* 添加新元素 */
    public void add(int value) {
        // 当列表已满时，扩容
        if (size == getCapacity()) {
            extendCapacity();
        }
        arr[size++] = value;
    }

    public void insert(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        // 判断是否需要进行扩容
        if (size == getCapacity()) {
            extendCapacity();
        }
        // 将index之后的元素向后移动一位
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = value;
        size++;
    }

    /* 返回被删除的元素 */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        int num = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        // 将列表末尾元素置为0，并将列表长度减一
        arr[size--] = 0;
        return num;
    }

    /* 列表扩容 */
    private void extendCapacity() {
        // 新建一个长度为原数组 extendRatio 倍的新数组，并将原数组复制到新数组
        arr = Arrays.copyOf(arr, capacity * extendRatio);
        // 更新列表容量
        capacity = arr.length;
    }

    public int[] toArray() {
        int size = size();
        // 创建一个长度为 size 的数组
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = get(i);
        }
        return array;
    }
}
