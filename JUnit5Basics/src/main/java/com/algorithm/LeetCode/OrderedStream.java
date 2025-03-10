package com.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
   Description: 1656. 设计有序流
   Author: 叁玖柒
   Date: 2025/2/24
   Time: 17:35
*/
public class OrderedStream {
    private final String[] stream;
    private int ptr = 0;
    public OrderedStream(int n) {
        stream = new String[n];
        ptr = 0;
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey - 1] = value;
        List<String> result = new ArrayList<>();
        while (ptr < stream.length && stream[ptr] != null) {
            result.add(stream[ptr]);
            ptr++;
        }
        return result;
    }
}
/*
解题思路
数据结构选择：
由于 id 是从 1 到 n 的整数，且需要按 id 递增的顺序返回值，我们可以使用一个数组来存储这些值，数组的索引对应 id（注意 id 从 1 开始，数组索引从 0 开始）。
指针 ptr 的作用：
ptr 指向当前期望的下一个 id。当插入一个 (id, value) 对时，如果 id == ptr，则可以开始从 ptr 开始，连续地收集并返回那些已经插入且 id 连续的值。
插入操作：
将 value 存储在数组的 id-1 位置。
如果 id == ptr，则从 ptr 开始，连续地收集数组中已存在的连续 id 的值，直到遇到一个未插入的位置。
收集完后，更新 ptr 为最后一个收集的 id + 1。
 */
