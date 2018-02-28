package com.aiesst.interview.guide;

import lombok.experimental.var;

/**
 * 给定一个数 pivot 将链表进行划分，链表前半部分小于 pivot，中间 等于 pivot，后半部分 大于 pivot
 *
 * @author ychost
 * @date 2018-2-28
 */
public class LinkedListPivotDivide {
    /**
     * 时间复杂度 O(N)，空间复杂度 o(1)
     *
     * @param header 单向链表头指针
     * @param pivot  划分基准数
     * @return 划分后的链表头指针
     */
    static OneWayNode<Integer> divide(OneWayNode<Integer> header, int pivot) {
        //划分链表的三部分
        OneWayNode<Integer> left = null, right = null, middle = null, leftEnd = null, rightEnd = null, middleEnd = null;
        var pointer = header;
        while (pointer != null) {
            var next = pointer.getNext();
            pointer.setNext(null);
            if (pointer.getData() < pivot) {
                if (left == null) {
                    left = pointer;
                    leftEnd = pointer;
                } else {
                    leftEnd.setNext(pointer);
                    leftEnd = pointer;
                }
            } else if (pointer.getData() == pivot) {
                if (middle == null) {
                    middle = pointer;
                    middleEnd = pointer;
                } else {
                    middleEnd.setNext(pointer);
                    middleEnd = pointer;
                }
            } else if (pointer.getData() > pivot) {
                if (right == null) {
                    right = pointer;
                    rightEnd = pointer;
                } else {
                    rightEnd.setNext(pointer);
                    rightEnd = pointer;
                }
            }
            pointer = next;
        }
        middle = middle != null ? middle.push(right) : right;
        return left != null ? left.push(middle) : middle;
    }

}
