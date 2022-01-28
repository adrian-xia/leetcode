package com.adrian.leetcode.codinginterviews;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xialei
 * @version Id: Offer30MinStack, v 0.1 2022/1/28 11:49 AM xialei Exp $
 */
public class Offer30MinStack {


    private Deque<Integer> stack = new LinkedList<>();

    private Deque<Integer> minStack = new LinkedList<>();


    /**
     * initialize your data structure here.
     */
    public Offer30MinStack() {

    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            minStack.push(x);
            return;
        }
        stack.push(x);
        Integer min = minStack.peek();
        if (x < min) {
            minStack.push(x);
        } else {
            minStack.push(min);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Offer30MinStack offer30MinStack = new Offer30MinStack();
        offer30MinStack.push(-2);
        offer30MinStack.push(0);
        offer30MinStack.push(-3);
        System.out.println(offer30MinStack.min());
        offer30MinStack.pop();
        System.out.println(offer30MinStack.top());
        System.out.println(offer30MinStack.min());
    }
}
