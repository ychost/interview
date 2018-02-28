package com.aiesst.interview.guide;

import lombok.experimental.var;

import java.util.Stack;

/**
 * 两个链表表示的整数相加
 * 比如：9->3->7 + 6->3 = 1->0->0->0
 *
 * @author ychost
 * @date 2018-2-28
 */
public class LinkedListAdd {
    /**
     * 利用栈结构来计算和
     * 当然也可以考虑将链表逆序然后求和
     * @param header1
     * @param header2
     * @return
     */
    static OneWayNode<Integer> add(OneWayNode<Integer> header1, OneWayNode<Integer> header2) {
        var stack1 = new Stack<Integer>();
        var stack2 = new Stack<Integer>();
        var stack3 = new Stack<OneWayNode<Integer>>();
        OneWayNode<Integer> sumHeader = null;
        //将链表数据存栈中
        var pointer = header1;
        while (pointer != null) {
            stack1.push(pointer.getData());
            pointer = pointer.getNext();
        }
        pointer = header2;
        while (pointer != null) {
            stack2.push(pointer.getData());
            pointer = pointer.getNext();
        }
        //从栈中取数据相加放入另一个栈中
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            var add1 = stack1.pop();
            var add2 = stack2.pop();
            var sum = add1 + add2 + carry;
            var node = new OneWayNode<Integer>(sum % 10);
            carry = sum / 10;
            stack3.push(node);
        }
        //未取完的数据放入结果栈中
        addRemain(stack1, stack3, carry);
        addRemain(stack2, stack3, carry);
        OneWayNode<Integer> sumPointer = null;
        //栈转链表
        while (!stack3.isEmpty()) {
            var node = stack3.pop();
            if (sumHeader == null) {
                sumHeader = node;
            } else {
                sumPointer.setNext(node);
            }
            sumPointer = node;
        }
        return sumHeader;
    }

    private static void addRemain(Stack<Integer> stack, Stack<OneWayNode<Integer>> sumStack, int carry) {
        if(stack.isEmpty()){
            return;
        }
        while (!stack.isEmpty()) {
            var sum = stack.pop() + carry;
            var node = new OneWayNode<Integer>(sum % 10);
            carry = sum / 10;
            sumStack.push(node);
        }
        sumStack.push(new OneWayNode<>(carry));
    }
}
