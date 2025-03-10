package com.structure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        /* 初始化队列 */
        Queue<Integer> queue = new LinkedList<>();

        /* 元素入队 */
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(5);
        queue.offer(4);

        System.out.println(queue);

        /* 访问队首元素 */
        if (!queue.isEmpty()) {
            int peek = queue.peek();
            System.out.println(peek);
        }
        /* 元素出队 */
        System.out.println(queue.poll());

        /* 获取队列的长度 */
        System.out.println(queue.size());
    }
}
