package com.adrian.leetcode.myalgo;

import java.util.Arrays;

/**
 * @author xl48886
 * @version Id: SortTest, v 0.1 2020/5/21 11:33 下午 xl48886 Exp $
 */
public class SortTest {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 3, 2, 5, 7, 9, 1};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    private static void selectSort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++)
                minIndex = nums[minIndex] < nums[j] ? minIndex : j;
            if (minIndex != i) {
                int tmp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = tmp;
            }
        }
    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            //提前退出标志位
            boolean flag = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    //表示有交换
                    flag = true;
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
            //若无交换，表示已经顺序正常
            if (!flag) break;
        }
    }

    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length;  i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] <= value) break;
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = value;
        }
    }

}
