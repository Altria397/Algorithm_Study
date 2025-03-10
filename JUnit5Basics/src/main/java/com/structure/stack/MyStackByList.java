package com.structure.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algorithm_Study
 * @description: 链表实现栈
 * @author: Altria397
 * @create: 2024-03-03 10:25
 */

public class MyStackByList {
    private final List<Integer> stack;
    private int len = 0;
    public MyStackByList() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(len, x);
        len++;
    }

    public int pop() {
        int elem = stack.get(len - 1);
        stack.remove(len - 1);
        len--;
        return elem;
    }

    public int top() {
        return stack.get(len - 1);
    }

    public boolean empty() {
        return len == 0;
    }
}
