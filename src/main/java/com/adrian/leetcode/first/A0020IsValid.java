package com.adrian.leetcode.first;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author xl48886
 * @version Id: A0020IsValid, v 0.1 2020/5/17 7:39 下午 xl48886 Exp $
 */
public class A0020IsValid {

    public boolean isValid(String s) {
        Map<Character, Character> mapper = new HashMap<>();
        mapper.put(')', '(');
        mapper.put('}', '{');
        mapper.put(']', '[');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (mapper.containsKey(s.charAt(i))) {
                if (!mapper.get(s.charAt(i)).equals(stack.pollLast()))
                    return false;
            } else {
                stack.offerLast(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

}
