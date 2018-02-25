package com.aiesst.interview.guide;

import lombok.Data;

import java.util.Stack;

/**
 * 《程序员代码面试指南》 汉诺塔
 *
 * @author ychost
 * @date 2018-1-31
 */
@Data
public class StackHanoi<T extends Comparable> {
    private Stack<T> stackA;
    private Stack<T> stackB;
    private Stack<T> stackC;
    private int recurMoveStep = 1;

    public StackHanoi(Stack<T> stackA) {
        this.stackA = stackA;
        stackB = new Stack<>();
        stackC = new Stack<>();
    }

    /**
     * 使用递归的方式解决汉诺塔问题
     */
    void hanoiRcur() {
        recurResolve(stackA.size(), stackA, stackB, stackC);
    }

    /**
     * 递归实现
     *
     * @param n
     * @param stackA
     * @param stackB
     * @param stackC
     */
    void recurResolve(int n, Stack<T> stackA, Stack<T> stackB, Stack<T> stackC) {
        if (n == 1) {
            // 只有一个盘子的情况
            move(1, stackA, stackC);
        } else {
            //将 A 中 1-(n-1) 的盘子移动到 B 中去，会使用到 C
            recurResolve(n - 1, stackA, stackC, stackB);
            //将 A 中 n 盘子移动到 B 中去
            move(n, stackA, stackC);
            //将 B 中 1-(n-1) 的盘子移动到 C 中去，会使用到 A
            recurResolve(n - 1, stackB, stackA, stackC);
        }
    }

    /**
     * 将 from 顶部的盘子移动到 to 中去
     *
     * @param n
     * @param from
     * @param to
     */
    void move(int n, Stack<T> from, Stack<T> to) {
        String fromStr = (from == stackA) ? "A" : (from == stackB) ? "B" : "C";
        String toString = (to == stackA) ? "A" : (to == stackB) ? "B" : "C";
        System.out.println("move " + fromStr + " to " + toString + " " + (recurMoveStep++) + " step");
        to.push(from.pop());
    }

    /**
     * 使用 栈 来解决汉诺塔问题
     */
    static void hanoiStack() {

    }
}
