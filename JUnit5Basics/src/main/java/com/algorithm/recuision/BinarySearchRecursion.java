package com.algorithm.recuision;

/**
 * @program: Algorithm_Study
 * @description: 递归版本的二分查找
 * @author: Altria397
 * @create: 2023-08-07 19:50
 */

public class BinarySearchRecursion {

    public int recursion(int[] nums, int target) {
        return recursion(nums, target, 0, nums.length);
    }

    /**
     * 内部方法，递归二分查找
     * @param nums 被查找的数组
     * @param target 目标值
     * @param i 起始索引
     * @param j 终止索引
     * @return 目标值的索引
     */
    private int recursion(int[] nums, int target, int i, int j) {
        if (i > j) {
            return -1;
        }
        int mid = (i + j) >>> 1;
        if (nums[mid] < target) {
            return recursion(nums, target, mid + 1, j);
        }else if (nums[mid] > target) {
            return recursion(nums, target, i, mid - 1);
        } else {
            return mid;
        }
    }
}
