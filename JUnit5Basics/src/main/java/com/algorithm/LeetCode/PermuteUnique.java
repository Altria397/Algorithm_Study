package com.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
   Description: 47. 全排列 II
   Author: 叁玖柒
   Date: 2025/2/6
   Time: 10:52
*/

public class PermuteUnique {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(permuteUnique.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(0, nums);
        ans.removeIf(list -> list.size() != nums.length);
        return ans;
    }

    private void dfs(int i, int[] nums) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        dfs(i + 1, nums);
        path.add(nums[i]);
        dfs(i + 1, nums);
        path.remove(path.size() - 1);
    }
}

