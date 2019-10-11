package com.adrian.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author xl48886
 * @version Id : A0004ReverseInteger, v 0.1 2019/10/12 上午12:11 xl48886 Exp $
 */
public class A0004ReverseInteger {

    public static void main(String[] args) {
        A0004ReverseInteger test = new A0004ReverseInteger();
        System.out.println(test.reverse(Integer.MAX_VALUE));
    }

    public int reverse(int x) {
        int rev = 0;
        int min = Integer.MIN_VALUE % 10;
        int max = Integer.MAX_VALUE % 10;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > max)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < min)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
