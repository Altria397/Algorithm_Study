package com.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
   Description: 131. 分割回文串 [M]
   Author: 叁玖柒
   Date: 2025/3/4
   Time: 16:10
*/
public class Partition {
    Solution solution = new Solution();

    public static void main(String[] args) {
        Partition partition = new Partition();
        System.out.println(partition.solution.partition("aab"));
    }
    static class Solution {
        private String s;
        private final List<List<String>> ans = new ArrayList<>();
        private final List<String> path = new ArrayList<>();
        public List<List<String>> partition(String s) {
            this.s = s;
            dfs(0,0);
            return ans;
        }

        private void dfs(int i, int start) {
            if (i == s.length()) {
                ans.add(new ArrayList<>(path));
                return;
            }

            if (i < s.length() - 1) {
                dfs(i + 1, start);
            }

            if (isPalindrome(start, i)) {
                path.add(s.substring(start, i + 1));
                dfs(i + 1, i + 1);
                path.remove(path.size() - 1);
            }

        }

        private boolean isPalindrome(int left, int right) {
            while (left < right) {
                if (s.charAt(left++) != s.charAt(right--)) return false;
            }
            return true;
        }
    }
}


