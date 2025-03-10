package com.algorithm.TestSearch;
import com.algorithm.Search.SeqSearch;
import com.algorithm.Search.InsertSearch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class TestSearch {
    @Test
    @DisplayName("顺序查找")
    public void test1 (){
        int[] array = {2, 12, 24, 5, 6, 17, 58, 23, 19, 9};
        SeqSearch seqSearch = new SeqSearch();
        System.out.println(seqSearch.seqSearch(array, 9));

        System.out.println(seqSearch.seqSearch(array, 99));
    }


    @Test
    @DisplayName("差值查找")
    public void test2 (){
        int[] array = {1, 3, 5, 6, 7, 9, 12, 16, 25, 29, 55};;
        InsertSearch insertSearch = new InsertSearch();
        System.out.println(insertSearch.insertSearch(array, 1));
        System.out.println(insertSearch.insertSearch(array, 9));
        System.out.println(insertSearch.insertSearch(array, 99));
        System.out.println(insertSearch.insertSearch(array, 55));
    }

}
