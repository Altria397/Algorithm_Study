package com.algorithm.TestSort;

import com.algorithm.Sort.Sort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

public class TestSort {
    @Test
    public void test1(){
        int[] array = {9,2,5,6,7,8,3,1,0,4};
        Sort sort = new Sort();
        System.out.println(Arrays.toString(sort.InsertDirectly(array)));
    }

    @Test
    public void test2(){
        int[] array = {9,2,5,6,7,8,3,1,0,4};
        Sort sort = new Sort();
        System.out.println(Arrays.toString(sort.SimpleSelect2(array)));
        System.out.println();
    }

    @Test
    public void test3() {
        int[] array = {9,2,5,6,7,8,3,1,0,4};
        Sort sort = new Sort();
        sort.QuickSort(array, 0, array.length - 1);
    }

    @Test
    @DisplayName("直接插入排序")
    public void test4() {
        int[] array = {9,2,5,6,7,8,3,1,0,4};
        Sort sort = new Sort();
        System.out.println(Arrays.toString(sort.InsertionSort(array)));
    }
}
