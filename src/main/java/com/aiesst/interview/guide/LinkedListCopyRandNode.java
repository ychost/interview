package com.aiesst.interview.guide;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.var;

import java.util.function.Consumer;

/**
 * 复制 RandNode 这样的链表
 *
 * @author ychost
 * @date 2018-2-28
 */
public class LinkedListCopyRandNode {
    /**
     * 复制链表
     *
     * @param header 待复制链表的头指针
     * @return 复制后的链表的头指针
     */
    static RandNode<Integer> copy(RandNode<Integer> header) {
        RandNode<Integer> copyHeader = null, copyPointer = null;
        var pointer = header;
        //复制 next 连接
        while (pointer != null) {
            var node = new RandNode<Integer>(pointer.getData());
            node.setRand(pointer);
            if (copyHeader == null) {
                copyHeader = node;
            } else {
                copyPointer.setNext(node);
            }
            copyPointer = node;
            pointer = pointer.getNext();
        }
        copyPointer = copyHeader;
        while(copyPointer != null){
            var rand = copyPointer.getRand().getRand();
        }

        //复制 rand 连接
        return copyHeader;
    }
}

/**
 * 比普通的单向链表多了一个随机指针
 *
 * @param <T>
 */
@Data
class RandNode<T> implements LinkedNode {
    private T data;
    private RandNode<T> next;
    private RandNode<T> rand;

    void foreach(Consumer<T> consumer) {
        var pointer = this;
        while (pointer != null) {
            if (consumer != null) {
                consumer.accept(pointer.getData());
            }
            pointer = pointer.getNext();
        }
    }

    void printRand() {
        var pointer = this;
        while (pointer != null) {
            System.out.print(pointer.getData() + " ->");
            pointer = pointer.getRand();
        }
    }

    RandNode(T data) {
        this.data = data;
    }
}
