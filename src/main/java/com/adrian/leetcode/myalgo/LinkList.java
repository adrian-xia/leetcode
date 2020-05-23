package com.adrian.leetcode.myalgo;

import com.adrian.leetcode.first.A0002AddTwoNumbers;

/**
 * @author xl48886
 * @version Id: LinkList, v 0.1 2020/5/20 1:11 下午 xl48886 Exp $
 */
public class LinkList {

    public static void main(String[] args) {
        ListNode listNode = initListNodeX();
        reverseList(listNode);
    }

    /**
     * 翻转链表
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
