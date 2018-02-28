package com.aiesst.interview.guide;

import lombok.experimental.var;

import java.util.Stack;

/**
 * 判断链表是否是一个回文
 *
 * @author ychost
 * @date 2018-2-26
 */
public class LinkedListIsPalindrome {
    /**
     * 判断是否为回文的普通解法
     *
     * @param header 单向链表的头指针
     * @return 判断结果
     */
    static boolean isPalindrome(OneWayNode header) {
        var stack = new Stack<Object>();
        var pointer = header;
        while (pointer != null) {
            stack.push(pointer.getData());
            pointer = pointer.getNext();
        }
        pointer = header;
        while (!stack.isEmpty()) {
            if (!pointer.getData().equals(stack.pop())) {
                return false;
            }
            pointer = pointer.getNext();
        }
        return true;
    }

    /**
     * 另一种高效解法，时间效率为 o(N)，空间效率为 o(1)
     * 该方法为反转链表右半部分，然后左半部分遍历的结果应该等于右半部分
     *
     * @param header 单向链表的头指针
     * @return 判断结果
     */
    static boolean isPalindrome2(OneWayNode header) {
        OneWayNode n1, n2, n3;
        n1 = header;
        n2 = header;
        //使得 n1 指向链表的中间节点
        while (n2.getNext() != null && n2.getNext().getNext() != null) {
            n1 = n1.getNext();
            n2 = n2.getNext().getNext();
        }
        n2 = n1.getNext();
        n1.setNext(null);
        //反转链表的右半部分
        while (n2 != null) {
            n3 = n2.getNext();
            n2.setNext(n1);
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = header;
        var res = true;
        //此时 n1 指向右反转链表的第一个节点，n2 指向左链表的第一个节点
        while (n1 != null && n2 != null) {
            if (!n1.getData().equals(n2.getData())) {
                res = false;
                break;
            }
            n1 = n1.getNext();
            n2 = n2.getNext();
        }
        //恢复链表
        n1 = n3.getNext();
        n3.setNext(null);
        //此时 n1 指向原链表的尾节点
        while (n1 != null) {
            n2 = n1.getNext();
            n1.setNext(n3);
            n3 = n1;
            n1 = n2;
        }
        return res;

    }

    /**
     * 反转一个链表，空间复杂度 o(1)
     *
     * @param header 单向链表头部指针
     * @return 反转后的链表的头指针
     */
    static OneWayNode reverseLinkedList(OneWayNode header) {
        var nodePre = header;
        var node = nodePre.getNext();
        OneWayNode nodeNext;
        while (node != null) {
            nodeNext = node.getNext();
            node.setNext(nodePre);
            nodePre = node;
            node = nodeNext;
        }

        //删除自指向
        header.setNext(null);
        return nodePre;
    }
}
