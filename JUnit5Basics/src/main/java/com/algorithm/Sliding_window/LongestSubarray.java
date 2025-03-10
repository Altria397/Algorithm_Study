package com.algorithm.Sliding_window;

/**
 * @program: Algorithm_Study
 * @description: 删掉一个元素以后全为 1 的最长子数组
 * @author: Altria397
 * @create: 2023-09-04 23:40
 */

public class LongestSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int ans = 0;
        int left = 0, right = 0;
        int zero = 0;
        while (right < nums.length) {
            if(nums[right] == 0) {
                zero++;
            }
            right++;
            while (zero > 1) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
            ans = Math.max(ans, right - left - 1);
        }
        return ans;
    }
}
