package com.adrian.leetcode.myalgo;

import javax.xml.transform.Source;
import java.util.Arrays;

/**
 * @author xl48886
 * @version Id: SortTest, v 0.1 2020/5/21 11:33 下午 xl48886 Exp $
 */
public class SortTest {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 3, 2, 5, 7, 9, 1};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void selectSort(int[] nums) {
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

    public static void bubbleSort(int[] nums) {
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

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] <= value) break;
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = value;
        }
    }


    /**
     * 归并排序
     *
     * @param nums
     */
    public static void mergeSort(int[] nums) {
        aux = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    private static int[] aux;

    private static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;//若左侧索引>=右侧索引，说明到底了
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    /**
     * 原地归并
     * @param nums
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi ; k++) {
            aux[k] = nums[k];
        }
        for (int k = lo; k <= hi ; k++) {
            if (i > mid) nums[k] = aux[j++];
            else if (j > hi) nums[k] = aux[i++];
            else if (aux[j] < aux[i]) nums[k] = aux[j++];
            else nums[k] = aux[i++];
        }
    }


}
