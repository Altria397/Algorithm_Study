package com.algorithm.LeetCode;

/*
   Description: 2595. 奇偶位数 [E]
   Author: 叁玖柒
   Date: 2025/2/20
   Time: 14:55
*/
public class EvenOddBit {

    public int[] evenOddBit(int n) {
        String bStr = Integer.toBinaryString(n);
        int len = bStr.length() - 1;
        int[] ans = new int[2];
        for (int index = bStr.length() - 1; index >= 0; index--) {
            if (bStr.charAt(index) == '1' && (len - index) % 2 == 0) {
                ans[0] = ans[0] + 1;
            } else if (bStr.charAt(index) == '1') {
                ans[1] = ans[1] + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        EvenOddBit evenOddBit = new EvenOddBit();
        System.out.println(evenOddBit.evenOddBit(50));
    }
}
