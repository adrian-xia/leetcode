package com.adrian.leetcode.first;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author xl48886
 * @version Id: A0136SingleNumber, v 0.1 2020/5/14 10:25 上午 xl48886 Exp $
 */
public class A0136SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber2(new int[] {3,4,1,4,2,2,3}));
    }

    /**
     * hashSet缓存
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        Iterator<Integer> it = set.iterator();
        return it.hasNext() ? it.next() : 0;
    }

    /**
     * 位运算异或
     * a ⊕ b ⊕ a = b ⊕ a ⊕ a = b ⊕ (a ⊕ a) = b ⊕ 0 = b
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int rst = 0;
        for (int num : nums) {
            rst = rst ^ num;
        }
        return rst;
    }

}
