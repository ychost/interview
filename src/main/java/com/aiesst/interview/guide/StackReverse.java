package com.aiesst.interview.guide;

import lombok.Data;
import lombok.experimental.var;

import java.util.Stack;

/**
 * 《程序员代码面试指南》 仅使用递归的方式反转一个栈
 *
 * @author ychost
 * @date 2018-1-30
 */
@Data
public class StackReverse {

    /**
     * 取出出栈底元素
     *
     * @param stack
     * @param <T>
     * @return
     */
    static <T> T pollBottom(Stack<T> stack) {
        var data = stack.pop();
        if (stack.isEmpty()) {
            return data;
        } else {
            //last 为 「栈底」元素
            var last = pollBottom(stack);
            //data 为 「栈底」之上的元素
            stack.push(data);
            return last;
        }
    }

    /**
     * 反转一个栈
     *
     * @param stack
     * @param <T>
     */
    static <T> void reverse(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }
        //将栈底元素一个一个取出来
        var data = pollBottom(stack);
        reverse(stack);
        //第一个放入的就是最后一次取出的「栈底部」,即 「栈顶」元素
        //从而实现了反转
        stack.push(data);
    }
}

