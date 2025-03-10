package com.structure.map;

import java.util.ArrayList;
import java.util.List;

/*
   Description: 基于数组实现的哈希表
   Author: 叁玖柒
   Date: 2025/1/15
   Time: 17:06
*/
public class ArrayHashMap {
    private final List<Pair> buckets;

    public ArrayHashMap() {
        buckets = new ArrayList<>();
        // 初始化数组，包含 100 个桶
        for (int i = 0; i < 100; i++) {
            buckets.add(null);
        }
    }

    /**
     * 获取值
     * @param key key
     * @return val
     */
    public Object get(int key) {
        int index = hashFunc(key);
        Pair pair = buckets.get(index);
        if (null == pair)
            return null;
        return pair.val;
    }

    /**
     * 添加值
     * @param key 键
     * @param val 值
     */
    public void put(int key, String val) {
        Pair pair = new Pair(key, val);
        int index = hashFunc(key);
        buckets.set(index, pair);
    }

    /**
     * 删除操作
     * 将对应键的val置为null
     * @param key 键
     */
    public void remove(int key) {
        int index = hashFunc(key);
        buckets.set(index, null);
    }

    public List<Pair> pairSet() {
        return new ArrayList<>(buckets);
    }

    /* 获取所有键 */
    public List<Integer> keySet() {
        List<Integer> keySet = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null)
                keySet.add(pair.key);
        }
        return keySet;
    }


    /* 获取所有值 */
    public List<Object> valueSet() {
        List<Object> valueSet = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null)
                valueSet.add(pair.val);
        }
        return valueSet;
    }

    /* 打印哈希表 */
    public void print() {
        for (Pair kv : pairSet()) {
            if (null == kv) continue;
            System.out.println(kv.key + " -> " + kv.val);
        }
    }

    private int hashFunc(int key) {
        return key % 100;
    }
}
