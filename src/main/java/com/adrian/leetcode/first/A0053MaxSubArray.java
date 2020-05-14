package com.adrian.leetcode.first;

/**
 * 最大子序和
 *
 * @author xl48886
 * @version Id: A0053MaxSubArray, v 0.1 2020/5/13 11:24 下午 xl48886 Exp $
 */
public class A0053MaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-4,-2,-3,-1}));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = nums[0];
        int pre = 0;
        for (int i : nums) {
            pre = Math.max(i, pre + i);
            max = Math.max(pre, max);
        }
        return max;
    }

}
