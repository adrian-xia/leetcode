package com.adrian.leetcode.first;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author xl48886
 * @version Id: A0015ThreeSum, v 0.1 2020/5/16 1:19 上午 xl48886 Exp $
 */
public class A0015ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;//排序后第一个数大于0，肯定无解
            if (i > 0 && nums[i] == nums[i - 1]) continue;//越过相同数
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;//去除重复数
                    while (l < r && nums[r] == nums[r - 1]) r--;//去除重复数
                    l++;
                    r--;
                    continue;
                }
                if (sum > 0) r--;
                else l++;
            }
        }
        return ans;
    }

}
