package com.adrian.leetcode.first;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xl48886
 * @version Id: A0560SubarraySum, v 0.1 2020/5/15 4:11 下午 xl48886 Exp $
 */
public class A0560SubarraySum {


    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和方法
     * pre[i] = pre[i - 1] + nums[i]
     * pre[i] - pre[j - 1] = k
     * pre[j - 1] = pre[i] - k
     * map: key=pre[j - 1], value = count(pre[j - 1])
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;

        /**
         * key=pre[j - 1]
         * value = pre[j - 1]这个值出现的次数
         *
         */
        Map<Integer, Integer> mp = new HashMap<>(20000);
        //此处添加一个，在第一个元素等于k的时候，可以计数，否则无法计数
        mp.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (mp.containsKey(pre - k))
                count += mp.get(pre - k);
            //此处记录当前pre出现的次数，若之前未出现，则使用默认值0+1
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
