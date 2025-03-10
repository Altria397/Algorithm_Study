package com.algorithm.TestSearch;

import com.algorithm.recuision.BinarySearchRecursion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @program: Algorithm_Study
 * @description: 测试查找
 * @author: Altria397
 * @create: 2023-08-07 19:56
 */

public class TestSearch2 {
    @Test
    @DisplayName("测试递归二分查找")
    public void test1 (){
        int[] nums = {1,5,8,12,34,66,78,90};
        BinarySearchRecursion rec = new BinarySearchRecursion();
        System.out.println(rec.recursion(nums, 12));
    }
}
