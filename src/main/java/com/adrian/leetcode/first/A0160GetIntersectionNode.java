package com.adrian.leetcode.first;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xl48886
 * @version Id: A0160GetIntersectionNode, v 0.1 2020/5/17 8:26 下午 xl48886 Exp $
 */
public class A0160GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        n2.next = n6;
        System.out.println(getIntersectionNode2(n1, n4));
    }

    /**
     * 双指针法
     * 最多走两圈
     * 若无相交，节点数一致，第一圈结束next均为null，返回null
     * 若无相交，节点数不一致，第二圈结束next均为null，返回null
     * 若有相交，并且在同一位置，则第一圈即返回相交节点
     * 若有相交，不同位置，则第二圈返回橡胶节点
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode one = headA;
        ListNode two = headB;
        while (one != two) {
            one = one != null ? one.next : headB;
            two = two != null ? two.next : headA;
        }
        return one;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
