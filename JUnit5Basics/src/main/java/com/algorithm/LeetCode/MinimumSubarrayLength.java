package com.algorithm.LeetCode;

/*
   Description: 3095. 或值至少 K 的最短子数组 I
   Author: 叁玖柒
   Date: 2025/1/16
   Time: 11:21
*/
public class MinimumSubarrayLength {
    public static void main(String[] args) {
        System.out.println(minimumSubarrayLength(new int[]{1,2,3}, 2));
        System.out.println(minimumSubarrayLength(new int[]{2,1,8}, 10));
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        int ans = nums.length, left = 0, right = 0;
        for (; right < nums.length; right++) {
            int or = nums[left];
            for (int i = left; i < right; i++) {
                or |= nums[i];
                if (or >= k) {
                    ans = Math.min(ans, i - left + 1);
                }
                if ((nums[i]) >= k) {
                    ans = 1;
                }
            }
        }
        return ans;
    }
}
