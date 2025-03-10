package com.algorithm.TestTree;

import com.structure.tree.TreeNode;

/*
   Description: 测试二叉树
   Author: 叁玖柒
   Date: 2025/3/7
   Time: 9:44
*/
public class TestBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(root.levelOrder(root));
        root.preOrder(root);
        System.out.println(root.list);
        root.postOrder(root);
        System.out.println(root.list);
        root.inOrder(root);
        System.out.println(root.list);
    }
}
