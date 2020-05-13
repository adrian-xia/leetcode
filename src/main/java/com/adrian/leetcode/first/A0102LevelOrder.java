package com.adrian.leetcode.first;

import java.util.*;

/**
 * 二叉树的层序遍历
 *
 * @author xl48886
 * @version Id: A0102LevelOrder, v 0.1 2020/5/13 5:57 下午 xl48886 Exp $
 */
public class A0102LevelOrder {


    public static void main(String[] args) {

    }

    /**
     * 广度优先
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            int currentSize = treeNodeQueue.size();
            List<Integer> currentOrder = new LinkedList<>();
            result.add(currentOrder);
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = treeNodeQueue.poll();
                currentOrder.add(node.val);
                if (node.left != null) treeNodeQueue.offer(node.left);
                if (node.right != null) treeNodeQueue.offer(node.right);
            }
        }
        return result;
    }

    /**
     * 深度优先递归
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, result, 0);
        return result;
    }

    private static void dfs(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) return;
        if (level == result.size()) {
            result.add(new LinkedList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) dfs(root.left, result, level + 1);
        if (root.right != null) dfs(root.right, result, level + 1);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
