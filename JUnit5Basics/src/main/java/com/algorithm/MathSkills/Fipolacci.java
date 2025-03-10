package com.algorithm.MathSkills;

/**
 * @program: Algorithm_Study
 * @description: 斐波拉契数列的相关技巧
 * @author: Altria397
 * @create: 2024-01-16 15:30
 */

public class Fipolacci {
    /*
        斐波拉契数列通项公式法
        F(0) = 0
        F(1) = 1
        F(n) = F(n-1) + F(n-2)
    */
    public static void main(String[] args) {
        System.out.println(fib(46));
    }
    /**
     * 通项公式法求斐波那契数列
     * @param n 需要求第n项斐波拉契数列值
     * @return int
     */
    public static int fib(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }

}
