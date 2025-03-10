package com.algorithm;

import java.util.*;

/**
 * @program: Algorithm_Study
 * @description:
 * @author: Altria397
 * @create: 2023-09-03 10:58
 */

public class test {
    public static void main(String[] args) {
        int num = 180;
        char[] bits = String.valueOf(num).toCharArray();
        System.out.println(bits);
        for (char bit : bits) {
            System.out.println(Integer.parseInt(String.valueOf(bit)));
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.removeIf(list -> list.size() != 3);
        StringBuilder strB = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        set.removeAll(setB);

        int[] time = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(1 & 5);
    }

    private static boolean check(int startTime, int endTime, List<int[]> calendar) {
        for (int[] time : calendar) {
            if (startTime < time[1] && time[0] < endTime) {
                return false;
            }
        }
        return true;
    }


    public static int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            int n = 0, temp = i;
            while (temp > 0) {
                n++;
                temp /= 10;
            }
            temp = i;
            if (n % 2 == 0) {
                int j = 0;
                int sumL = 0, sumR = 0;
                while (j <= n) {
                    j++;
                    if (j > (n / 2)) {
                        sumR = i % 10;
                        temp /= 10;
                        continue;
                    }
                    sumL = temp % 10;
                    temp /= 10;
                }
                if (sumL == sumR) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int compress(char[] chars) {
        StringBuilder strB =  new StringBuilder();
        int i = 0, n = chars.length;
        while (i < n) {
            int start = i;
            strB.append(chars[start]);
            i++;
            while (i < n && chars[i] == chars[start]) {
                i++;
            }
            if (i - start != 1) {
                strB.append(i - start);
            }
        }
        chars = strB.toString().toCharArray();
        for (char c : chars) {
            System.out.println(c);
        }
        System.out.println();
        return chars.length;
    }

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length(), i = 0;
        while (i < n) {
            // 有bug，start的初始化总是跟着i变化的，但是start应该是按顺序访问字符的，需要修改
            int start = i;
            i++;
            // 初始化子串
            String str = s.substring(start, i);
            // 分组循环，不断右移指针，并且判断当前指向的字符是否在前面截取的子串中
            while (i < n && isNotContain(str, s.charAt(i))) {
                i++;
                // 重新截取子串
                str = s.substring(start, i);
            }
            // 更新最长子串长度
            ans = Math.max(ans, str.length());
        }
        return ans;
    }

    // 判断当前子串是否包含该字符
    public static boolean isNotContain(String str, char c) {
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
