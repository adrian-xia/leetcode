package com.adrian.leetcode.codinginterviews;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * 1. 先往stack1灌tail数据
 * 2. 若是遇到deleteHead，则先判断stack2是否有数据
 * 有数据就直接pop，
 * 没有数据的话就将stack1的数据全部压入stack2，在进行pop
 * 若是stack1也没有数据，则返回-1
 *
 * @author xialei
 * @version Id: Offer09CQueue, v 0.1 2022/1/28 11:16 AM xialei Exp $
 */
public class Offer09CQueue {

    private Deque<Integer> stack1 = new LinkedList<>();
    private Deque<Integer> stack2 = new LinkedList<>();

    public Offer09CQueue() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            }
            while (!stack1.isEmpty()) {
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }
        return stack2.pop();
    }

}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */