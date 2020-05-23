package com.adrian.leetcode.myalgo;

import sun.print.SunMinMaxPage;

import java.util.Arrays;

/**
 * 二分查找
 *
 * @author xl48886
 * @version Id: BinarySearch, v 0.1 2020/5/20 1:04 上午 xl48886 Exp $
 */
public class BinarySearch {


    public static void main(String[] args) {
//        int[] arrays = new int[]{-6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4};
//        int[] arrays2 = new int[]{6, 5, 8, 11, 17, 20, 0, 1, 2, 3, 4};
//        Arrays.sort(arrays2);
//        System.out.println(binarySearch1(arrays2));
        int[] arrays3 = new int[]{-6, -5, -4, -3, -2, -1, -1, -1, 0, 1, 2, 3, 4};
//        System.out.println(binarySearchFirst(arrays3, -1));

        int[] arrays5 = new int[]{0, 1};
//        System.out.println(binarySearch1(arrays5, 0));

        int[] arrays4 = new int[]{5, 7, 7, 8, 8, 10};

        System.out.println(binarySearchLastEqualsK(arrays4, 8));

    }


    /**
     * 二分查找最后一个小于一个指定数的数
     *
     * @param nums
     * @return
     */
    public static int binarySearchLastLessThanK(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] >= k) {
                r = mid - 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] >= k) return nums[mid];
                l = mid + 1;
            }
        }
        return 0;
    }

    /**
     * 查找第一个给定值的元素
     * 闭区间
     * [l, r]
     *
     * @param nums
     * @param k
     * @return -1 没查到数据
     */
    public static int binarySearchFirstEqualsK(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < k) l = mid + 1;
            else if (nums[mid] == k && (mid == 0 || nums[mid - 1] < k)) return mid;
            else r = mid - 1;
        }
        return -1;
    }

    /**
     * 半开区间
     * [l, h)
     * @param nums
     * @param target
     * @return
     */
    private int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length; // 注意 h 的初始值
        while (l < h) { // 此处做小于，不然会出现死循环
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return h;
    }

    /**
     * 查找最后一个给定值的元素
     *
     * @param nums
     * @param k
     * @return -1 没查到数据
     */
    public static int binarySearchLastEqualsK(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > k) r = mid - 1;
            else if (nums[mid] == k && (mid == nums.length - 1 || nums[mid + 1] > k)) return mid;
            else l = mid + 1;
        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{-1, -1};
    }

}
