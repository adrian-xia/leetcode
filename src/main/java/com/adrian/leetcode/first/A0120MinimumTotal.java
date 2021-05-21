package com.adrian.leetcode.first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xl48886
 * @version Id: A0120MinimumTotal, v 0.1 2020/7/14 5:19 下午 xl48886 Exp $
 */
public class A0120MinimumTotal {

    public static void main(String[] args) {
        List<Integer> one = new ArrayList<>();
        one.add(2);
        List<Integer> two = new ArrayList<>();
        two.add(3);
        two.add(4);
        List<Integer> three = new ArrayList<>();
        three.add(6);
        three.add(5);
        three.add(7);
        List<Integer> four = new ArrayList<>();
        four.add(4);
        four.add(1);
        four.add(8);
        four.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(one);
        triangle.add(two);
        triangle.add(three);
        triangle.add(four);
        int i = minimumTotal(triangle);
        System.out.println(i);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] rst = new int[n][n];
        for(int i = triangle.size() - 1; i > 0; i--) {
            List<Integer> line = triangle.get(i);
            for (int j = 0; j < line.size(); j++) {
                if (i == triangle.size() - 1) {
                    rst[i][j] = line.get(j);
                } else {
                    rst[i][j] = Math.min(rst[i + 1][j], rst[i + 1][j + 1]) + line.get(j);
                }
            }
        }
        return rst[0][0];
    }

}
