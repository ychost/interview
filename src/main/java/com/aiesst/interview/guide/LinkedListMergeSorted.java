package com.aiesst.interview.guide;

import lombok.experimental.var;

/**
 * 合并两个有序链表 ☆
 *
 * @author ychost
 * @date 2018-3-5
 */
public class LinkedListMergeSorted {
    /**
     * 合并两个有序链表，合并后的链表仍有序
     *
     * @param header1 有序链表1
     * @param header2 有序链表2
     * @return 合并后的有序链表
     */
    static OneWayNode<Integer> merge(OneWayNode<Integer> header1, OneWayNode<Integer> header2) {
        OneWayNode<Integer> header = null, pointer = null;
        var pointer1 = header1;
        var pointer2 = header2;
        while (pointer1 != null && pointer2 != null) {
            OneWayNode<Integer> node = null;
            if (pointer1.getData() < pointer2.getData()) {
                var next = pointer1.getNext();
                node = pointer1;
                pointer1 = next;
            } else {
                var next = pointer2.getNext();
                node = pointer2;
                pointer2 = next;
            }
            node.setNext(null);
            if (header == null) {
                header = node;
            } else {
                pointer.setNext(node);
            }
            pointer = node;
        }
        if (pointer1 != null) {
            pointer.setNext(pointer1);
        }
        if (pointer2 != null) {
            pointer.setNext(pointer2);
        }
        return header;
    }
}

