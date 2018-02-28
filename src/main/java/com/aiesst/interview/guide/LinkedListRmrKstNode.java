package com.aiesst.interview.guide;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.var;

/**
 * 删除链表中倒数第 K 个点
 *
 * @author ychost
 * @date 2018-2-23
 */
public class LinkedListRmrKstNode {

    /**
     * 删除单向链表中的倒数第 K 个节点
     *
     * @param header 单向链表头部指针
     * @param k      位置，从 1 开始
     * @return 删除结果
     */
    static OneWayNode rmsKstOneWayNode(OneWayNode header, int k) {
        //链表长度
        var length = 0;
        OneWayNode pointer = header;
        while (pointer != null) {
            pointer = pointer.getNext();
            length += 1;
        }
        //删除的位置
        var index = length - k;
        if (index < 0) {
            return header;
        }
        //删除节点的前一个节点
        pointer = header;
        for (int i = 0; i < index - 1; i++) {
            pointer = pointer.getNext();
        }
        if (pointer == null) {
            return header;
        }
        if (pointer == header) {
            header = pointer.getNext();
            pointer.setNext(null);
            return header;
        }
        pointer.setNext(pointer.getNext().getNext());
        return header;
    }

    /**
     * 删除双向链表中的倒数第 K 个节点
     *
     * @param header 双向链表头指针
     * @param k      位置，从 1 开始
     * @return 删除结果
     */
    static TwoWayNode rmsKstTwoWayNode(TwoWayNode header, int k) {
        var tail = header;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        var pointer = tail;
        for (int i = 1; i < k; i++) {
            pointer = pointer.getPrevious();
            if (pointer == null) {
                return header;

            }
        }
        if (pointer.getPrevious() != null) {
            pointer.getPrevious().setNext(pointer.getNext());
        } else {
            pointer.getNext().setPrevious(null);
            header = pointer.getNext();
        }
        if (pointer.getNext() != null) {
            pointer.getNext().setPrevious(pointer.getPrevious());
        }
        return header;
    }

    /**
     * 打印链表
     *
     * @param header
     */
    static void printLinkedNode(LinkedNode header) {
        var pointer = header;
        while (pointer != null) {
            System.out.print(pointer.getData() + " ->");
            pointer = pointer.getNext();
        }
        System.out.println();
    }
}


interface LinkedNode {
    LinkedNode getNext();

    Object getData();

    default void print() {
        var pointer = this;
        if (pointer.getNext() == this) {
            System.out.print(pointer.getData() + " ->");
        }
        while (pointer != null && pointer.getNext() != this) {
            System.out.print(pointer.getData() + " ->");
            pointer = pointer.getNext();
        }
        System.out.println();
    }
}

/**
 * 单向链表
 */
@Data
class OneWayNode<T> implements LinkedNode {
    private T data;
    private OneWayNode<T> next;
    private OneWayNode<T> tail;

    /**
     * 是否为尾节点
     *
     * @return
     */
    public boolean isTail() {
        return next == null;
    }

    public OneWayNode(T data) {
        this.data = data;
        tail = this;
    }


    public OneWayNode<T> push(OneWayNode<T> node) {
        OneWayNode pointer = this;
        while (pointer.getNext() != null) {
            pointer = pointer.getNext();
        }
        pointer.setNext(node);
        return this;
    }

    public OneWayNode<T> push(T data) {
        var node = new OneWayNode<T>(data);
        return push(node);
    }
}

/**
 * 双向链表
 */
@Data
class TwoWayNode implements LinkedNode {
    private Object data;
    private TwoWayNode previous;
    private TwoWayNode next;

    public TwoWayNode(Object data) {
        this.data = data;
    }

    public void push(Object data) {
        var node = new TwoWayNode(data);
        var pointer = this;
        while (pointer.getNext() != null) {
            pointer = pointer.getNext();
        }
        pointer.setNext(node);
        node.setPrevious(pointer);
    }
}

