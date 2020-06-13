package com.adrian.leetcode.first;

/**
 * 暴力法
 * 时间复杂度O(m+n)，空间复杂度O(m+n)
 * @author xl48886
 * @version Id: A0004FindMedianSortedArrays, v 0.1 2020/5/24 8:16 下午 xl48886 Exp $
 */
public class A0004FindMedianSortedArrays {

    public static void main(String[] args) {
        A0004FindMedianSortedArrays test = new A0004FindMedianSortedArrays();
        int[] num1 = new int[]{1, 3};
        int[] num2 = new int[]{2};

        test.findMedianSortedArrays(num1, num2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //暴力法
        int[] mergeResult = merge(nums1, nums2);
        if (mergeResult.length % 2 == 1) {
            return mergeResult[mergeResult.length / 2];
        } else {
            return (mergeResult[mergeResult.length / 2] + mergeResult[mergeResult.length / 2 - 1]) / 2.0;
        }
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int idx1 = 0, idx2 = 0;
        int[] mergeResult = new int[nums1.length + nums2.length];
        for (int i = 0; i < mergeResult.length; i++) {
            if (idx1 == nums1.length && idx2 < nums2.length) mergeResult[i] = nums2[idx2++];
            else if (idx2 == nums2.length && idx1 < nums1.length) mergeResult[i] = nums1[idx1++];
            else if (nums1[idx1] <= nums2[idx2]) mergeResult[i] = nums1[idx1++];
            else mergeResult[i] = nums2[idx2++];
        }
        return mergeResult;
    }

}
