package com.algorithm.LeetCode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
   Description: 2274. 不含特殊楼层的最大连续楼层数
   Author: 叁玖柒
   Date: 2025/1/6
   Time: 11:29
*/
public class MaxConsecutive {
    public static void main(String[] args) {
        int ans = maxConsecutive1(2, 9, new int[]{4, 6});
        System.out.println(ans);
    }

    // 该方法面临top和
    public static int maxConsecutive1(int bottom, int top, int[] special) {
        int ans = 0;
        if ((top - bottom + 1) == special.length) return 0;
        int left = 0;
        Set<Integer> specialSet = Arrays.stream(special).boxed().collect(Collectors.toSet());
        for (int i = bottom; i <= top; i++) {
            if (specialSet.contains(i)) {
                left = i + 1;
            } else {
                ans = Math.max(i - left + 1, ans);
            }
        }
        return ans;
    }

    public static int maxConsecutive2(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int n = special.length;
        int ans = Math.max(special[0] - bottom, top - special[n - 1]);
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, special[i] - special[i - 1] - 1);
        }
        return ans;
    }
}
