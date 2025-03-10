package com.algorithm.LeetCode;

import java.util.*;

/*
   Description: 658. 找到 K 个最接近的元素
   Author: 叁玖柒
   Date: 2025/2/18
   Time: 16:23
*/
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        List<Integer[]> diffArr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Integer[] temp = new Integer[2];
            temp[0] = i;
            temp[1] = Math.abs(arr[i] - x);
            diffArr.add(temp);
        }
        // Arrays.sort(diffArr);
        // 根据数组元素值升序排序
        diffArr.sort(Comparator.comparingInt((Integer[] nums) -> nums[1]));
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(arr[diffArr.get(i)[0]]);
        }
        ans.sort(Comparator.comparingInt(a -> a));
        return ans;
    }

    public static void main(String[] args) {
        FindClosestElements findClosestElements = new FindClosestElements();
        System.out.println(findClosestElements.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(findClosestElements.findClosestElements(new int[]{1, 1, 2, 3, 4, 5}, 4, -1));
    }
}
