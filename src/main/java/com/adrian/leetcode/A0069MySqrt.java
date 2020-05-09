package com.adrian.leetcode;

/**
 * @author xl48886
 * @version Id: A0069MySqrt, v 0.1 2020/5/9 10:44 上午 xl48886 Exp $
 */
public class A0069MySqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt1(100));
    }

    /**
     * 秀珍计算器法
     *
     * @param x
     * @return
     */
    public static int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    /**
     * 二分法
     * 定义左指针，中位数指针，右指针
     * 特殊 0, 1
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
