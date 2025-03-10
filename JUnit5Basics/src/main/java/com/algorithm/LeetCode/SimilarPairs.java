package com.algorithm.LeetCode;

import java.util.HashSet;
import java.util.Set;

/*
   Description: 2506. 统计相似字符串对的数目
   Author: 叁玖柒
   Date: 2025/2/24
   Time: 17:21
*/
public class SimilarPairs {
    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('b');
        set.add('c');
        Set<Character> set2 = new HashSet<>();
        set2.add('a');
        set2.add('b');

        System.out.println(set.equals(set2));

    }
}
