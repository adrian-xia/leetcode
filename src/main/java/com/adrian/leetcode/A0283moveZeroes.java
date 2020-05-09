package com.adrian.leetcode;

/**
 * @author xl48886
 * @version Id: A0283moveZeroes, v 0.1 2020/5/9 8:03 下午 xl48886 Exp $
 */
public class A0283moveZeroes {

    public static void main(String[] args) {
        moveZeroes1(new int[]{0, 1, 2, 3, 0});
    }

    /**
     * 这里参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点x，然后把所有小于等于x的元素放到x的左边，大于x的元素放到其右边。
     * 这里我们可以用0当做这个中间点，把不等于0(注意题目没说不能有负数)的放到中间点的左边，等于0的放到其右边。
     * 这的中间点就是0本身，所以实现起来比快速排序简单很多，我们使用两个指针i和j，只要nums[i]!=0，我们就交换nums[i]和nums[j]
     * 请对照动态图来理解：
     *
     * 作者：wang_ni_ma
     * 链接：https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     */
    private static void moveZeroes1(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[flag];
                nums[flag++] = tmp;
            }
        }
    }

}
