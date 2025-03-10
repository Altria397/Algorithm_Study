package com.algorithm.DynamicArray;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray {
    private int size = 0; //逻辑大小
    private int capacity = 8;//数组容量
    private int[] array = {}; //初始化静态数组、

    public void addLast(int element){
//        array[size] = element;
//        size++;
        add(size, element);
    }

    public void add(int index, int element){
        CheckAndGrow();

        //添加逻辑
//        if (index < 0 || size < index){
//            System.out.println("超出边界");
//        }
        //System.arraycopy(拷贝数组， 拷贝的起始位置，目标数组，拷贝后的起始位置，拷贝元素个数)
        if (0 <= index && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    public void CheckAndGrow(){
        //容量检查
        if (size == 0){
            array = new int[capacity];
        }
        else if (size == capacity){
            //数组放满，扩容
            //capacity += capacity >> 1;
            //System.out.println(capacity);
            capacity = capacity + (capacity >> 1);
            System.out.println(capacity);
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public int remove(int index){
        int removed = array[index];
        if (index < size - 1) {
            //将删除位置后的元素全部前移
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            size--;
        }
        return removed;
    }

    //获取特定元素
    public int get(int index){
        return array[index];
    }

    //遍历方法
    public void forEach(Consumer<Integer> consumer){
        //函数式接口，返回值根据传入的函数式
        for (int i = 0; i < size; i++)
        {
            consumer.accept(array[i]);
        }
    }

    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(array,0,size));//拷贝有效内容
    }
}
