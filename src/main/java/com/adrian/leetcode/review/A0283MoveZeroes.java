package com.adrian.leetcode.review;

/**
 * @author xl48886
 * @version Id: A0283MoveZeroes, v 0.1 2020/5/15 11:06 下午 xl48886 Exp $
 */
public class A0283MoveZeroes {



    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = tmp;
                idx++;
            }
        }
    }

}
