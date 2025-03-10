package com.algorithm.LeetCode;

import java.util.HashSet;
import java.util.Set;

/*
   Description: 3. 无重复字符的最长子串
   Author: 叁玖柒
   Date: 2025/1/14
   Time: 15:41
*/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abacdaa"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0, left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        for (; right < arr.length; right++) {
            while (set.contains(arr[right])) {
                set.remove(arr[left]);
                left++;
            }
            set.add(arr[right]);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
