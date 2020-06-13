package com.adrian.leetcode.myjvm;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author xl48886
 * @version Id: VolatileTest, v 0.1 2020/5/22 10:07 下午 xl48886 Exp $
 */
public class VolatileTest {

    public static volatile int flag = 0;


    public static void main(String[] args) {
        System.out.println("start");
        long start = System.currentTimeMillis();
        new Thread(() -> {
            while (true) {
                if (flag == 1) {
                    System.out.println("end1, cost = " + (System.currentTimeMillis() - start));
                    break;
                }
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = 1;
            System.out.println("end2, cost = " + (System.currentTimeMillis() - start));
        }).start();

    }

    private volatile int a = 0;
    private int b = 0;

    @Test
    public void testVolatile() throws Exception{
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                a++;
            }

        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                a++;
            }
        }).start();
        Thread.sleep(5000);

        System.out.println("a="+a);
    }

}
