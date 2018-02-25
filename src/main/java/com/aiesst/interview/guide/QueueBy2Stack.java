package com.aiesst.interview.guide;

import lombok.Data;

import java.util.Stack;

/**
 * 《程序员代码面试指南》 由两个栈组成一个队列
 *
 * @param <T>
 * @author ychost
 * @date 2018-1-30
 */
@Data
public class QueueBy2Stack<T> {
    private Stack<T> stackA;
    private Stack<T> stackB;

    public QueueBy2Stack() {
        stackB = new Stack<>();
        stackA = new Stack<>();
    }

    synchronized public void push(T data) {
        stackA.push(data);
    }

    synchronized public T peek() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
        return stackB.peek();
    }

    synchronized public T poll() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
        return stackB.pop();
    }
}
