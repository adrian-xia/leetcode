package com.adrian.leetcode.first;

/**
 * @author xl48886
 * @version Id: A0050MyPow, v 0.1 2020/5/11 12:13 下午 xl48886 Exp $
 */
public class A0050MyPow {

    public static void main(String[] args) {
        System.out.println(myPow(4, -2));
    }


    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return rest * half * half;
    }

    // TODO: 2020/5/15
    public static double myPow2(double x, int n) {



        return 0;
    }


}
