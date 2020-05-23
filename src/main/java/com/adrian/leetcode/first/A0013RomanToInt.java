package com.adrian.leetcode.first;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xl48886
 * @version Id: A0013RomanToInt, v 0.1 2020/5/18 12:30 上午 xl48886 Exp $
 */
public class A0013RomanToInt {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int pre = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer current = map.get(s.charAt(i));
            if (current <= pre) {
                sum = sum + current;
            } else {
                sum = sum + current - pre * 2;
            }
            pre = current;
        }
        return sum;
    }

}
