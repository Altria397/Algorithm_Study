package com.structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
   Description: 树节点
   Author: 叁玖柒
   Date: 2025/3/6
   Time: 18:06
*/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public List<Integer> list = new ArrayList<>();
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }

    /**
     * 层序遍历（广度优先搜索BFS）
     * @param root 根节点
     * @return 节点值
     */
    public List<Integer> levelOrder(TreeNode root) {
        // 采用队列实现程层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 初始化链表
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return list;
    }
    /**
     * 前序遍历（前序、中序、后序遍历本质上都为深度有线搜索DFS）
     * @param root 根节点
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root 根节点
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    /**
     * 后序遍历
     * @param node 根节点
     */
    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        list.add(node.val);
    }

    /**
     * 二叉树的最大深度
     * @param root 根节点
     * @return 最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 交换当前节点的左子树和右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归翻转左子树
        invertTree(root.left);
        // 递归翻转右子树
        invertTree(root.right);

        return root;
    }
}
