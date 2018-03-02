package com.aiesst.interview.guide;

import lombok.experimental.var;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 删除单链表的重复节点
 *
 * @author ychost
 * @date 2018-3-2
 */
public class LinkedListDelRepeat {
    /**
     * 时间复杂度 o(N)
     * 空间复杂度 o(N)
     *
     * @param header 单链表的头指针
     * @return 不含重复元素的单链表头指针
     */
    static OneWayNode makeUnique(OneWayNode header) {
        var set = new HashSet<Object>();
        var pointer = header;
        OneWayNode pre = null;
        while (pointer != null) {
            var next = pointer.getNext();
            if (set.add(pointer.getData())) {
                pre = pointer;
            } else {
                pre.setNext(next);
            }
            pointer = next;
        }
        return header;
    }

    /**
     * 另一种解法，时间复杂度 o(N^2)，空间复杂度 o(1)
     *
     * @param header 单链表的头指针
     * @return 不含重复元素的单链表头指针
     */
    static OneWayNode makeUnique2(OneWayNode header) {
        OneWayNode uHeader = null, uEnd = null, pointer = header;
        while (pointer != null) {
            var next = pointer.getNext();
            if (uHeader == null) {
                uHeader = pointer;
                uEnd = pointer;
                pointer.setNext(null);
            } else {
                if (!linkedListContains(uHeader, pointer.getData())) {
                    uEnd.setNext(pointer);
                    pointer.setNext(null);
                    uEnd = pointer;
                }
            }
            pointer = next;
        }
        return uHeader;
    }

    static boolean linkedListContains(OneWayNode header, Object data) {
        var pointer = header;
        while (pointer != null) {
            if (pointer.getData() == data) {
                return true;
            }
            pointer = pointer.getNext();
        }
        return false;
    }
}
