package com.adrian.leetcode.twoSum0001;

import com.alibaba.fastjson.JSON;

/**
 * @author xl48886
 * @version Id : TowSumTest, v 0.1 2019/07/18 下午5:00 xl48886 Exp $
 */
public class TowSumTest {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 30;
        int[] indexes = twoSum(nums, target);
        System.out.println(JSON.toJSONString(indexes));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }

}
