package com.aiesst.interview.guide;

import lombok.experimental.var;

import java.util.Stack;

/**
 * 《程序员代码面试指南》 栈排序
 *
 * @author ychost
 * @date 2018-1-31
 */
@SuppressWarnings("unchecked")
public class StackSort {

    /**
     * 用一个栈去实现另一个栈的排序，只允许用一个栈，不准用其它数据结构，可申请新变量
     *
     * @param stack
     * @param <T>
     */
    static <T extends Comparable> Stack<T> sortByStack(Stack<T> stack) {
        Stack<T> sortStack = new Stack<>();
        while (!stack.isEmpty()) {
            var data = stack.pop();
            //找到 data 元素在 sortStack 中的位置
            //将临时元素腾到 stack 中去
            while (!sortStack.isEmpty() && (sortStack.peek().compareTo(data) > 0)) {
                stack.push(sortStack.pop());
            }
            //放入 data
            sortStack.push(data);
            //在将临时放入的 stack 的元素放回 sorteStack
            while (!stack.isEmpty() && sortStack.peek().compareTo(stack.peek()) < 0) {
                sortStack.push(stack.pop());
            }
        }
        return sortStack;
    }
}
