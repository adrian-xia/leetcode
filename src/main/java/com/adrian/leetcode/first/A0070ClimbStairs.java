package com.adrian.leetcode.first;

/**
 * 斐波拉契数列
 *
 * @author xl48886
 * @version Id: A0070ClimbStairs, v 0.1 2020/5/9 12:40 下午 xl48886 Exp $
 */
public class A0070ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs2(50));
    }

    /**
     * 递归实现
     * 时间复杂度2^n
     * 效率极低
     *
     * @param n
     * @return
     */
    private static int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     * 循环实现递归
     * 时间复杂度 => n
     * @param n
     * @return
     */
    private static int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }


}
