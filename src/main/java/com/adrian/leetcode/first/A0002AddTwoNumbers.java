package com.adrian.leetcode.first;

/**
 * 2.两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author xl48886
 * @version Id : A0002AddTwoNumbers, v 0.1 2019/07/18 下午6:54 xl48886 Exp $
 */
public class A0002AddTwoNumbers {

    public static void main(String[] args) {
        A0002AddTwoNumbers object = new A0002AddTwoNumbers();
        ListNode l1 = object.initListNodeX();
        ListNode l2 = object.initListNodeY();
        ListNode listNode = object.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        ListNode temp = result;
        ListNode l1Temp = l1.next;
        ListNode l2Temp = l2.next;
        int carry = (l1.val + l2.val) / 10;
        while (l1Temp != null || l2Temp != null || carry != 0) {
            int v1 = l1Temp != null ? l1Temp.val : 0;
            int v2 = l2Temp != null ? l2Temp.val : 0;
            int value = (v1 + v2 + carry) % 10;
            carry = (v1 + v2 + carry) / 10;
            temp.next = new ListNode(value);
            temp = temp.next;
            l1Temp = l1Temp != null ? l1Temp.next : null;
            l2Temp = l2Temp != null ? l2Temp.next : null;
        }
        return result;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sumVal = v1 + v2 + carry;
            carry = sumVal / 10;
            cursor.next = new ListNode(sumVal % 10);
            cursor = cursor.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode initListNodeX() {
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        return a;
    }

    private ListNode initListNodeY() {
        ListNode a = new ListNode(5);
        a.next = new ListNode(6);
        a.next.next = new ListNode(4);
        return a;
    }
}
