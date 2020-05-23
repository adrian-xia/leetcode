package com.adrian.leetcode.first;

/**
 * 二叉树的最近公共祖先
 * todo 重要
 * @author xl48886
 * @version Id: LA0236owestCommonAncestor, v 0.1 2020/5/10 10:19 上午 xl48886 Exp $
 */
public class A0236LowestCommonAncestor {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        root.left = node5;
        root.right = node1;
        root.left.left = node6;
        root.left.right = node2;
        root.right.left = node0;
        root.right.right = node8;
        root.left.right.left = node7;
        root.left.right.right = node4;

        TreeNode lowestCommonAncestor = lowestCommonAncestor(root, node7, node8);
    }

    /**
     * DFS，深度优先，查找
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        //此处如果left==right, 则返回root
        return root;
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
