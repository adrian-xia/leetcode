package com.adrian.leetcode.first;

/**
 * @author xl48886
 * @version Id: A0035SearchInsert, v 0.1 2020/7/17 21:38 xl48886 Exp $
 */
public class A0035SearchInsert {

    public int searchInsert1(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                if (nums[mid - 1] < target) return mid;
                else r = mid - 1;
            } else {
                if (nums[mid + 1] > target) return mid + 1;
                else l = mid + 1;
            }
        }
        return 0;
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
