package com.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
   Description: 2080. 区间内查询数字的频率
   Author: 叁玖柒
   Date: 2025/2/18
   Time: 10:06
*/
public class RangeFreqQuery {
    private final Map<Integer, List<Integer>> pos = new HashMap<>();
    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            pos.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> list = pos.get(value);
        if (list == null) {
            return 0;
        }
        return binarySearch(list, right) - binarySearch(list, left);
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
