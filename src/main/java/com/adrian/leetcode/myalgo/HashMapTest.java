package com.adrian.leetcode.myalgo;

import java.util.Arrays;

/**
 * @author xl48886
 * @version Id: HashMapTest, v 0.1 2020/6/24 4:17 下午 xl48886 Exp $
 */
public class HashMapTest {

    static volatile int i;

    public static void main(String[] args) throws Exception {

        new Thread(new T()).start();
        new Thread(new T()).start();

        Thread.sleep(5000);
        System.out.println(i);
    }

    private static class T implements Runnable {
        @Override
        public void run() {
            for (int j = 0; j < 10000; j++) {
                i += 1;
            }
        }
    }

}
