package com.algorithm.LeetCode;

import java.util.PriorityQueue;

/*
   Description: 3066. 超过阈值的最少操作数 II
   Author: 叁玖柒
   Date: 2025/1/15
   Time: 16:31
*/
public class MinOperations {
    public static void main(String[] args) {
        /*
         * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
         * 一次操作中，你将执行：
         * 选择 nums 中最小的两个整数 x 和 y 。
         * 将 x 和 y 从 nums 中删除。
         * 将 min(x, y) * 2 + max(x, y) 添加到数组中的任意位置。
         * 注意，只有当 nums 至少包含两个元素时，你才可以执行以上操作。
         * 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
         */


        System.out.println(minOperations(new int[]{1, 2, 4, 1, 2, 5, 2, 6}, 2));
    }

    public static int minOperations(int[] nums, int k) {
        int ans = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.offer((long)num);
        }

        while (queue.size() > 1 && queue.peek() < k) {
            long x = queue.poll();
            long y = queue.poll();

            queue.offer(Math.min(x, y) * 2 + Math.max(x, y));
            ans++;
        }
        return ans;
    }
}


class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.offer((long)num);
        }

        while (queue.size() > 1 && queue.peek() < k) {
            long x = queue.poll();
            long y = queue.poll();

            queue.offer(Math.min(x, y) * 2 + Math.max(x, y));
            ans++;
        }
        return ans;
    }

}
