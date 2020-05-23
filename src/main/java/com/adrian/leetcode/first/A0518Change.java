package com.adrian.leetcode.first;

/**
 * @author xl48886
 * @version Id: A0518Change, v 0.1 2020/5/16 8:15 上午 xl48886 Exp $
 */
public class A0518Change {


    /**
     * 动态规划
     * dp = new int[amount + 1]
     * 0 1 2 ... amount
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];//包含0
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] = dp[i] + dp[i - coin];//dp[i]初始化0
            }
        }
        return dp[amount];//返回最大的amount
    }

}
