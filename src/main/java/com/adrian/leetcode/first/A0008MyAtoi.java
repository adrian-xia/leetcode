package com.adrian.leetcode.first;

/**
 * @author xl48886
 * @version Id: A0008MyAtoi, v 0.1 2020/6/9 7:32 下午 xl48886 Exp $
 */
public class A0008MyAtoi {

    public static int myAtoi(String str) {
        boolean minus = false;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int rst = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //去除空格
            if (' ' == c) {
                continue;
            }
            //判断第一个非空格字符是否是数字，或者-
            if ('-' == c) {
                minus = true;
                continue;
            }
            //判断数字类型
            if ('0' > c || '9' < c) break;
            int v = c - '0';
            int maxValue = minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            int absMaxValueSubTen = Math.abs(maxValue / 10);
            int absMaxValueModTen = Math.abs(maxValue % 10);
            if (rst > absMaxValueSubTen
                    || rst == absMaxValueSubTen && v > absMaxValueModTen) {
                return maxValue;
            }
            rst = rst * 10 + v;
        }

        return rst;
    }

    public static void main(String[] args) {
        myAtoi("42");
    }
}
