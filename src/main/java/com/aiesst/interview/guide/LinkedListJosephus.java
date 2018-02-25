package com.aiesst.interview.guide;

import lombok.experimental.var;

/**
 * 环形单链表的约瑟夫问题
 *
 * @author ychost
 * @date 2018-2-24
 */
public class LinkedListJosephus {
    /**
     * 获取存活下来的节点
     *
     * @param header 链表头部指针
     * @param num    报数值
     * @return 没有报到该数，即存活下来的节点
     */
    static OneWayNode getAliveNode(OneWayNode header, int num) {
        var pointer = header;
        //形成环状
        //如果 header 所在链表已是环状则找到 header 的 previous
        while (pointer.getNext() != null && pointer.getNext() != header) {
            pointer = pointer.getNext();
        }
        pointer.setNext(header);
        //尾指针
        OneWayNode previous = pointer;
        //头指针
        pointer = header;
        int i = 0;
        while (pointer != pointer.getNext()) {
            //删除报数到 num 的节点
            if (++i % num == 0) {
                previous.setNext(pointer.getNext());
            }
            previous = pointer;
            pointer = pointer.getNext();
        }
        return pointer;
    }


    /**
     * 另一种高效的方法，在 o(N) 的时间内完成
     *
     * @param header
     * @param num
     * @return
     */
    static OneWayNode getAliveNode2(OneWayNode header, int num) {
        var pointer = header;
        //获取链表的长度
        var size = 1;
        while (pointer.getNext() != null && pointer.getNext() != header) {
            size++;
            pointer = pointer.getNext();
        }
        pointer = header;
        var aliveNum = getAliveNum(size, num);
        while (--aliveNum != 0) {
            pointer = pointer.getNext();
        }
        pointer.setNext(pointer);
        return pointer;
    }

    /**
     * 使用递归的方式直接获取约瑟夫问题中存活的节点编号
     *
     * @param size 单向链的长度
     * @param num  报数
     * @return 唯一存活的节点编号
     */
    static int getAliveNum(int size, int num) {
        if (size == 1) {
            return 1;
        }
        //长度为 size 与 (size-1) 存活节点编号的关系
        return (getAliveNum(size - 1, num) + (num - 1) % size) % size + 1;
    }
}
