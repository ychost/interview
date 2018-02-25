package com.aiesst.interview.guide;

import lombok.experimental.var;
import lombok.extern.java.Log;

/*
 * 反转链表
 *
 * @author ychost
 * @date   2018-2-23
 */
@Log
public class LinkedListReverse {
    /**
     * 反转单向链表
     *
     * @param header 单向链表头部指针
     * @return 反转后的单向链表头部指针
     */
    static OneWayNode oneWayNodeReverse(OneWayNode header) {
        var pointer = header;
        OneWayNode previous = null;
        while (pointer != null) {
            var next = pointer.getNext();
            pointer.setNext(previous);
            previous = pointer;
            pointer = next;
        }
        log.info("hello world");
        return previous;
    }


    /**
     * 反转双向链表
     *
     * @param header 双向链表的头部指针
     * @return 反转后的双向链表头部指针
     */
    static TwoWayNode twoWayNodeReverse(TwoWayNode header) {
        var pointer = header;
        while (true) {
            var next = pointer.getNext();
            pointer.setNext(pointer.getPrevious());
            pointer.setPrevious(pointer.getNext());
            if (next != null) {
                pointer = next;
            } else {
                break;
            }
        }
        return pointer;
    }
}
