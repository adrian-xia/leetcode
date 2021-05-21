package com.adrian.leetcode.myalgo;

import com.adrian.leetcode.first.A0002AddTwoNumbers;

/**
 * @author xl48886
 * @version Id: LinkList, v 0.1 2020/5/20 1:11 下午 xl48886 Exp $
 */
public class LinkList {


    public static void main(String[] args) {
        long a = -83282382389389289L;
        long b = 274738734878347L;
        System.out.println(add(a, b));
        System.out.println(add2(a, b));
    }

    public static String add(long a, long b) {
        String strA = new StringBuilder(a + "").reverse().toString();
        String strB = new StringBuilder(b + "").reverse().toString();
        String base = strA.length() > strB.length() ? strA : strB;
        String other = base == strA ? strB : strA;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < base.length(); i++) {
            int baseIndex = base.charAt(i) - '0';
            int otherIndex = 0;
            if (i < other.length()) {
                otherIndex = other.charAt(i) - '0';
            }
            int total = baseIndex + otherIndex + carry;
            sb.append(total % 10);
            carry = total / 10;
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static String add2(long a, long b) {
        if (a < 0 ^ b < 0) {
            return String.valueOf(a + b);
        }
        boolean flag = false;
        if (a < 0 && b < 0) {
            flag = true;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        long base = Math.max(a, b);
        long other = Math.min(a, b);
        StringBuilder sb = new StringBuilder();
        long carry = 0;
        while (base != 0) {
            long baseIndex = base % 10;
            long otherIndex = other % 10;
            long total = baseIndex + otherIndex + carry;
            sb.append(total % 10);
            carry = total / 10;
            base = base / 10;
            other = other / 10;
        }
        if (carry > 0) sb.append(carry);
        if (flag) sb.append('-');
        return sb.reverse().toString();
    }


    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;//头结点next指向null
            prev = curr;
            curr = tmp;
        }
        //到最后一个节点的时候，操作完毕curr=null，prev为翻转后的头节点
        //每次结束后，curr为断开的节点
        return prev;
    }

    /**
     * 递归翻转
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode initListNodeX() {
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        return a;
    }
}
