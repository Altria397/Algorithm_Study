package com.structure.tree;

import java.util.ArrayList;
import java.util.List;

/*
   Description: 数组二叉树
   Author: 叁玖柒
   Date: 2025/3/7
   Time: 10:27
*/
public class ArrayBinaryTree {
    public List<Integer> tree;

    public ArrayBinaryTree(List<Integer> tree) {
        this.tree = tree;
    }

    public int getSize() {
        return tree.size();
    }

    public Integer val(int i) {
        if (i < 0 || i >= tree.size()) {
            return null;
        }
        return tree.get(i);
    }

    public Integer left(int i) {
        return 2 * i + 1;
    }

    public Integer right(int i) {
        return 2 * i + 2;
    }

    public Integer parent(int i) {
        if (i == 0) {
            return null;
        }
        return (i - 1) / 2;
    }
    /**
     * 层序遍历
     * @return 层序遍历结果
     */
    public List<Integer> levelOrder() {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < tree.size(); i++) {
            if (null == val(i)) {
                continue;
            }
            res.add(val(i));
        }
        return res;
    }

    public void preOrder(int index) {
    }
}
