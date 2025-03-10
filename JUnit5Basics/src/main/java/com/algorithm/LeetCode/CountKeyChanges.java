package com.algorithm.LeetCode;

/*
   Description: 3019. 按键变更的次数
   Author: 叁玖柒
   Date: 2025/1/7
   Time: 14:18
*/
public class CountKeyChanges {
    public static void main(String[] args) {
        System.out.println('a' & 31);
        System.out.println('A' & 31);
        System.out.println('b' & 31);
        System.out.println('B' & 31);
        System.out.println('a' & 'A');
        System.out.println(Integer.toBinaryString('a'));
        System.out.println(Integer.toBinaryString('A'));
        System.out.println(Integer.toBinaryString(31));
    }

    public int countKeyChanges(String s) {
        int count = 0;
        char prev = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (prev - c != 0 && Math.abs(prev - c) != 32) {
                count++;
            }
            prev = c;
        }
        return count;
    }


    /**
     * 位运算，两个字符的ascii码相&，值不为1则说明不是同一个字符
     * @param s 字符串
     * @return 变更次数
     */
    public int countKeyChanges2(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if ((s.charAt(i - 1) & 31) != (s.charAt(i) & 31)) {
                ans++;
            }
        }
        return ans;
    }
}
