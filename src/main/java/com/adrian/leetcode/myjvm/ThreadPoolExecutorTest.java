package com.adrian.leetcode.myjvm;

/**
 * @author xl48886
 * @version Id: ThreadPoolExecutorTest, v 0.1 2020/5/24 10:04 下午 xl48886 Exp $
 */
public class ThreadPoolExecutorTest {


    public static void main(String[] args) {
        System.out.println(workerCountOf(10));
    }
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    private static int workerCountOf(int c)  { return c & CAPACITY; }

}
