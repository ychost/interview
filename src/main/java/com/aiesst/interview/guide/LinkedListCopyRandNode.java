package com.aiesst.interview.guide;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.var;

import java.util.Collections;
import java.util.HashMap;
import java.util.function.Consumer;

/**
 * 复制 RandNode 这样的链表
 *
 * @author ychost
 * @date 2018-2-28
 */
public class LinkedListCopyRandNode {
    /**
     * 复制链表，使用 HashMap 来保存复制对应关系
     *
     * @param header 待复制链表的头指针
     * @return 复制后的链表的头指针
     */
    static RandNode<Integer> copy(RandNode<Integer> header) {
        RandNode<Integer> copyHeader = null, copyPointer = null;
        var map = new HashMap<RandNode<Integer>, RandNode<Integer>>();
        var pointer = header;
        //复制 next 连接
        while (pointer != null) {
            //复制对应关系
            if (!map.containsKey(pointer)) {
                var node = new RandNode<Integer>(pointer.getData());
                map.put(pointer, node);
            }
            if (!map.containsKey(pointer.getRand())) {
                if (pointer.getRand() != null) {
                    var node = new RandNode<Integer>(pointer.getRand().getData());
                    map.put(pointer.getRand(), node);
                }
            }
            //关联关系对象
            RandNode<Integer> copyNode = map.get(pointer);
            if (copyPointer == null) {
                copyHeader = copyNode;
            } else {
                copyPointer.setNext(copyNode);
            }
            copyPointer = copyNode;
            copyPointer.setRand(map.get(pointer.getRand()));

            pointer = pointer.getNext();
        }
        return copyHeader;
    }

    /**
     * 另一种高效的做法，时间复杂度 o(N)，只使用几个临时变量
     * 创建这样的数据结构 1-1'-2-2'...
     * 将复制的节点保存在原节点后面，然后寻找复制 rand 节点就在圆 rand 节点后面
     *
     * @param header
     * @return
     */
    static RandNode<Integer> copyEff(RandNode<Integer> header) {
        var pointer = header;
        RandNode<Integer> next = null;
        //复制节点
        while (pointer != null) {
            next = pointer.getNext();
            var copy = new RandNode<Integer>(pointer.getData());
            pointer.setNext(copy);
            copy.setNext(next);
            pointer = next;
        }
        //连接 rand 节点
        pointer = header;
        while (pointer != null && pointer.getNext() != null) {
            if (pointer.getRand() != null) {
                var copyRand = pointer.getRand().getNext();
                var copyNode = pointer.getNext();
                copyNode.setRand(copyRand);
            }
            pointer = pointer.getNext().getNext();
        }

        RandNode<Integer> copyHeader = null, copyPointer = null;
        pointer = header;
        //取出复制的链表
        while (pointer != null) {
            var copyNode = pointer.getNext();
            if (copyPointer == null) {
                copyHeader = copyNode;
            } else {
                copyPointer.setNext(copyNode);
            }
            copyPointer = copyNode;
            var orgNext = pointer.getNext().getNext();
            pointer.setNext(orgNext);
            pointer = orgNext;
        }
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


    RandNode(T data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        return this.data.hashCode();
    }
}
