package com.algorithm.LeetCode;

/**
 * @program: Algorithm_Study
 * @description: 下一个更大的数值平衡数
 * @author: Altria397
 * @create: 2023-12-09 22:37
 */

public class NextBeautifulNumber {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; ++i) {
            if (isBalance(i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isBalance(int x) {
        int[] bits = new int[10];
        while (x > 0) {
            int bit = x % 10;
            bits[bit]++;
            x /= 10;
        }
        for (int i = 0; i < 10; i++) {

             // 很疑惑，这段代码为什么不行
             if (0 == i) {
                if (bits[i] > 0) {
                    return false;
                }
             } else if (i > 0 && bits[i] != i) {
                return false;
             }

            /*if (bits[i] > 0 && bits[i] != i) {
                return false;
            }*/
        }
        return true;
    }

    public static void main(String[] args) {
        NextBeautifulNumber n = new NextBeautifulNumber();
        System.out.println(n.nextBeautifulNumber(1));
    }
}
