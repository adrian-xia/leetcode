package com.adrian.leetcode.first;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
 * 1 翻译成 “b”，……，
 * 11 翻译成 “l”，……，
 * 25 翻译成 “z”。
 * 一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，
 * 分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 2^31
 *
 * @author xl48886
 * @version Id: B0046, v 0.1 2020/6/9 1:01 下午 xl48886 Exp $
 */
public class B0046TranslateNum {

    /**
     * 动态规划
     * 类似爬楼梯
     *
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        String numStr = String.valueOf(num);
        int[] dp = new int[numStr.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= numStr.length(); i++) {
            String tmp = numStr.substring(i - 2, i);
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[numStr.length()];
    }

    /**
     * 回溯
     *
     *
     * @param num
     * @return
     */
    public static int translateNum2(int num) {
        String numStr = String.valueOf(num);
        return backTrace(numStr, 0);
    }

    private static int backTrace(String numStr, int pos) {
        if (pos == numStr.length()) {
            return 1;
        }
        if (pos == numStr.length() - 1                                      //最后一位，只有一组
                || numStr.substring(pos, pos + 1).equals("0")               //两位，第一位为0，说明这两位小于10，则只有一组
                || numStr.substring(pos, pos + 2).compareTo("25") > 0) {    //两位，数字大于25，说明不在26个字母内，则只有一组
            return backTrace(numStr, pos + 1);
        } else {
            return backTrace(numStr, pos + 1) + backTrace(numStr, pos + 2);
        }
    }

    public static void main(String[] args) {
        translateNum2(1);
    }
}
