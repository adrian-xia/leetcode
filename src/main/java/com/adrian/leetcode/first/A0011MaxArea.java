package com.adrian.leetcode.first;

/**
 * 1. 对向移动
 * 2. 双指针
 *
 * @author xl48886
 * @version Id: A0011MaxArea, v 0.1 2020/5/9 11:37 上午 xl48886 Exp $
 */
public class A0011MaxArea {

    public static void main(String[] args) {

    }

    private static int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = height.length - 1; j > i; j--) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }

    private static int maxArea2(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

}
