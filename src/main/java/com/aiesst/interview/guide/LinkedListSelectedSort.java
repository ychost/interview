package com.aiesst.interview.guide;

import lombok.experimental.var;

/**
 * 单链表选择排序 ☆
 *
 * @author ychost
 * @date 2018-3-2
 */
public class LinkedListSelectedSort {
    /**
     * 要求空间复杂度 o(1)
     *
     * @param header 单向链表头指针
     * @return 排序后的链表头指针
     */
    static OneWayNode<Integer> sort(OneWayNode<Integer> header) {
        var pointer = header;
        OneWayNode sHeader = null, sTail = null;
        //获取最小节点，并将其移动到到 sTail 后面
        while (pointer != null) {
            var minNode = getMinNode(pointer);
            pointer = deleteNode(pointer, minNode);
            if (sHeader == null) {
                sHeader = minNode;
            } else {
                sTail.setNext(minNode);
            }
            sTail = minNode;
        }
        return sHeader;
    }


    /**
     * 删除单链表的某个节点
     *
     * @param header  单链表的头指针
     * @param delNode 待删除的节点
     * @return 删除节点后的单链表头指针
     */
    static OneWayNode<Integer> deleteNode(OneWayNode<Integer> header, OneWayNode<Integer> delNode) {
        var pointer = header;
        if (delNode == header) {
            return header.getNext();
        }
        while (pointer != null && pointer.getNext() != delNode) {
            pointer = pointer.getNext();
        }
        if (pointer != null) {
            pointer.setNext(pointer.getNext().getNext());
        }
        return header;
    }

    /**
     * 获取最小值的节点
     *
     * @param header 单链表头指针
     * @return 值最小的节点
     */
    static OneWayNode<Integer> getMinNode(OneWayNode<Integer> header) {
        var pointer = header;
        var minNode = header;
        while (pointer != null) {
            if (minNode.getData() > pointer.getData()) {
                minNode = pointer;
            }
            pointer = pointer.getNext();
        }
        return minNode;
    }
}
