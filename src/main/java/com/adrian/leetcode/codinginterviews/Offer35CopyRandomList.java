package com.adrian.leetcode.codinginterviews;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xialei
 * @version Id: Offer30MinStack, v 0.1 2022/1/28 11:49 AM xialei Exp $
 */
public class Offer35CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node, Node> cacheMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (cacheMap.get(head) == null) {
            Node rst = new Node(head.val);
            //此处需要先PUT，否则后续一直查找不到该Node，会一直循环的递归
            cacheMap.put(head, rst);
            rst.next = copyRandomList(head.next);
            rst.random = copyRandomList(head.random);
        }
        return cacheMap.get(head);
    }

    //todo
    public Node copyRandomList2(Node head) {
        return null;
    }

    public static void main(String[] args) {
        //head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        node0.next = node1;
        Node node2 = new Node(11);
        node1.next = node2;
        Node node3 = new Node(10);
        node2.next = node3;
        Node node4 = new Node(1);
        node3.next = node4;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;

        Offer35CopyRandomList offer35CopyRandomList = new Offer35CopyRandomList();
        Node rst = offer35CopyRandomList.copyRandomList(node0);
        System.out.println(rst);
    }
}
