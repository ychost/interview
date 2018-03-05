package com.aiesst.interview.guide;

import lombok.experimental.var;

/**
 * 向有序的环形单链表插入新节点
 *
 * @author ychost
 * @date 2018-3-5
 */
public class LinkedListInsertNum {
    /**
     * 环形链表不降序
     *
     * @param header 环形链表起始节点
     * @param num    带插入节点值
     * @return 插入节点后的新链表头指针
     */
    static OneWayNode<Integer> insert(OneWayNode<Integer> header, int num) {
        var pointer = header;
        var node = new OneWayNode<Integer>(num);
        while (pointer != null && pointer.getNext() != null) {
            var next = pointer.getNext();
            if (pointer.getData() <= num && pointer.getNext().getData() >= num || pointer.getNext() == header) {
                node.setNext(next);
                pointer.setNext(node);
                return header;
            }
            pointer = next;
        }

        return header;
    }
}
