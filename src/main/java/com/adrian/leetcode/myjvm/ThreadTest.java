package com.adrian.leetcode.myjvm;

import org.junit.Test;

/**
 * @author xl48886
 * @version Id: ThreadTest, v 0.1 2020/6/16 2:10 下午 xl48886 Exp $
 */
public class ThreadTest {

    @Test
    public void test1() {
        PrintLThread printLThread = new PrintLThread();
        PrintOThread printOThread = new PrintOThread();
        printLThread.joinThread = printOThread;
        printOThread.joinThread = printLThread;
        printLThread.start();
        printOThread.start();
    }

    public static class PrintLThread extends Thread {

        private Thread joinThread;

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("l");
                try {
                    joinThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class PrintOThread extends Thread {

        private Thread joinThread;

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("o");
                try {
                    joinThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
