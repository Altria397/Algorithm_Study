package com.algorithm.TestbinarySearch;
import com.algorithm.Search.BinarySearch;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class BinarySearchTest {
    @Test
    @DisplayName("基础版二分查找")
    public void first(){
        int[] array = {1, 3, 5, 6, 7, 9, 12, 16, 25, 29, 55};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearchBasic(array, 6));
    }
}
