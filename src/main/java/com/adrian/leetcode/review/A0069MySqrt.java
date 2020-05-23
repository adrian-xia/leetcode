package com.adrian.leetcode.review;

/**
 * x 的平方根
 * @author xl48886
 * @version Id: A0069MySqrt, v 0.1 2020/5/15 7:07 下午 xl48886 Exp $
 */
public class A0069MySqrt {

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid * mid < x) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

}
