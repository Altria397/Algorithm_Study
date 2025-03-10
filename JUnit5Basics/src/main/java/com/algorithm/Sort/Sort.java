package com.algorithm.Sort;

import java.util.Arrays;
import java.util.List;

public class Sort {
    public int[] InsertDirectly(int[] array){
        for (int i =0; i < array.length; i++){
            int temp = array[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--){
                if (array[j] > temp){
                    array[j + 1] = array[j];
                }else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
        return array;
    }

    public int[] InsertionSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]){
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }else {
                    break;
                }
            }
        }
        return arr;
    }

    public int[] SimpleSelect(int[] array){
        int n = array.length;
        for (int i = 0; i < n; i++){
            //int temp = array[i];
            for (int j = i - 1; 0 <= j; j--){
                if (array[i] < array[j]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
                else if (array[j] < array[i]){
                    break;
                }
            }
        }
        return array;
    }

    //每次从数组中选择一个最小的元素放在当前指向的开始位置
    public int[] SimpleSelect2(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            //int temp = array[i];
            //int min = array[i];
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[index]) {
                    index = j;
                    //min =  array[j];
                }
            }
            if (index != i){
                int temp = array[i];
                //array[i] = min;
                array[i] = array[index];
                array[index] = temp;
            }
        }
        return array;
    }

    public void QuickSort(int[] array, int low, int high){
        if (low > high){
            return ;
        }
        int i = low, j = high;
        int pivot = low;
        while (i < j){
            while (i < j && array[pivot] < array[j]){
                j--;
            }
            while (i < j && i < array.length){
                if (array[i] > array[pivot])
                    break;
                low++;
            }
            if (i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int t = array[j];
        array[j] = array[pivot];
        array[pivot] = t;
        System.out.println(j + " " + Arrays.toString(array));
        QuickSort(array, low, j - 1);
        QuickSort(array, j + 1, high);
    }
}
