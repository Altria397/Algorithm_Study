package com.algorithm.TestDynamicArray;
import com.algorithm.DynamicArray.DynamicArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
//import org.junit.jupiter.api.Assertions;

public class TestDynamicArray {
    @Test
    public void test1(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.add(2,6);

        for (int i = 0; i < 6; i++){
            System.out.println(dynamicArray.get(i));
        }
    }

    @Test
    public void test2(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.add(2,6);

        dynamicArray.forEach((element)->{
            System.out.println(element);
        });
    }

    @Test
    public void test4(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.stream().forEach((element)->{
            System.out.println(element);
        });
    }

    @Test
    @DisplayName("测试删除")
    public void test5(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        int removed = dynamicArray.remove(2);
        System.out.println(removed);
        //assertEquals();
        System.out.println("-------------");
        dynamicArray.stream().forEach((element)->{
            System.out.println(element);
        });
    }

    @Test
    @DisplayName("测试扩容")
    public void test6(){
        DynamicArray dynamicArray = new DynamicArray();
        for(int i = 0; i < 9; i++){
            dynamicArray.addLast(i);
            System.out.println(i);
            dynamicArray.stream().forEach((element)->{
                System.out.print(element);
            });
            System.out.println();
        }
    }
}
