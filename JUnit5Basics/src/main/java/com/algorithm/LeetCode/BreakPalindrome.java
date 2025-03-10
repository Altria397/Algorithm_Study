package com.algorithm.LeetCode;

/*
   Description: 1328. 破坏回文串
   Author: 叁玖柒
   Date: 2025/3/5
   Time: 10:12
*/
public class BreakPalindrome {
    static class Solution {
        public String breakPalindrome(String palindrome) {
            int len = palindrome.length();
            if (len == 1) return "";
            char[] s = palindrome.toCharArray();
            for (int i = 0; i < len / 2; i++) {
                if (s[i] != 'a') {
                    s[i] = 'a';
                    return String.valueOf(s);
                }
            }
            s[len - 1] = 'b';
            return String.valueOf(s);
        }

        public String breakPalindrome2(String palindrome) {
            int len = palindrome.length();
            if (len == 1) return "";
            char[] s = palindrome.toCharArray();
            int i = 0;
            for (; i < len / 2; i++) {
                if (s[i] != 'a') {
                    s[i] = 'a';
                    break;
                }
            }
            if (i == len / 2) {
                s[len - 1] = 'b';
            }
            return String.valueOf(s);
        }
    }
}
