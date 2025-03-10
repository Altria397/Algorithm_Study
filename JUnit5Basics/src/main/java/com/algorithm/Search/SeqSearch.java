package com.algorithm.Search;

public class SeqSearch {
    public int seqSearch(int[] array, int target){
        //int index = -1;
        for (int i = 0; i < array.length; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }
}
