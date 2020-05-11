package com.adrian.leetcode.first;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author xl48886
 * @version Id : A0003LengthOfLongestSubstring, v 0.1 2019/07/19 11:35 xl48886 Exp $
 */
public class A0003LengthOfLongestSubstring {

    public static void main(String[] args) {
        A0003LengthOfLongestSubstring o = new A0003LengthOfLongestSubstring();
        System.out.println(o.lengthOfLongestSubstring("pwwkewasdfasddwq"));
    }

    /**
     * 滑动窗口解法
     * 复杂度O(1)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int length = s.length(), maxSubLength = 0;
        Map<Character, Integer> charMap = new HashMap<>(s.length());
        for (int sIndex = 0, eIndex = 0; eIndex < length; eIndex++) {
            if (charMap.containsKey(s.charAt(eIndex))) {
                sIndex = Math.max(charMap.get(s.charAt(eIndex)), sIndex);
            }
            maxSubLength = Math.max(maxSubLength, eIndex - sIndex + 1);
            charMap.put(s.charAt(eIndex), eIndex + 1);
        }
        return maxSubLength;
    }

}
