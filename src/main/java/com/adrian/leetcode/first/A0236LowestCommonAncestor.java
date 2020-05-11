package com.adrian.leetcode.first;

/**
 * 二叉树的最近公共祖先
 *
 * @author xl48886
 * @version Id: LA0236owestCommonAncestor, v 0.1 2020/5/10 10:19 上午 xl48886 Exp $
 */
public class A0236LowestCommonAncestor {


    public static void main(String[] args) {

    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
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
