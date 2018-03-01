package com.aiesst.interview.guide;

import lombok.experimental.var;

import java.util.HashMap;

/**
 * 两个链表相交的一系列问题
 *
 * @author ychost
 * @date 2018-3-1
 */
public class LinkedListIntersect {
    /**
     * 获取两个链表的第一个相交点，如果不相交则返回 null
     * 要求时间复杂度 o(M+N)，空间复杂度 o(1)
     *
     * @param header1 链表1，可能有环
     * @param header2 链表2，可能有环
     * @return 相交点
     */
    static OneWayNode getIntersectPoint(OneWayNode header1, OneWayNode header2) {
        var loop1 = getLoopNode(header1);
        var loop2 = getLoopNode(header2);
        if (loop1 == null && loop2 == null) {
            return getNoLoopIntersect(header1, header2, null, null);
        } else if (loop1 != null && loop2 != null) {
            return getLoopIntersect(header1, header2);
        }
        return null;
    }


    /**
     * 获取两个有环链表的交点
     *
     * @param header1 有环表
     * @param header2 有环表
     * @return
     */
    static OneWayNode getLoopIntersect(OneWayNode header1, OneWayNode header2) {
        var loop1 = getLoopNode(header1);
        var loop2 = getLoopNode(header2);
        //如果一个链表有环，另一个链表无环
        //则必然不相交
        var noIntersect = loop1 == null ? loop2 != null : loop2 == null;
        if (noIntersect) {
            return null;
        }
        //两个链表共用一个入环点，则交点在入环点之前
        //则可视作为 header1->loop1，header2->loop2 之间的无环表的交点
        if (loop1 == loop2) {
            return getNoLoopIntersect(header1, header2, loop1.getNext(), loop2.getNext());
            //两个链表的入环点不一样
        } else {
            var pointer = loop2.getNext();
            while (pointer != loop1 && pointer != loop2) {
                pointer = pointer.getNext();
            }
            //只有两个链表入一个环才有交点
            //此时返回 loop1，loop2 都可以
            if (pointer == loop1) {
                return loop1;
            }
        }
        return null;
    }

    /**
     * header1->end1 链表和 header2->end2 链表之间的第一个交点
     *
     * @param header1 链表1头指针
     * @param header2 链表2头指针
     * @param end1    链表1 tail.next
     * @param end2    链表2 tail.next
     * @return 第一个相交点
     */
    static OneWayNode getNoLoopIntersect(OneWayNode header1, OneWayNode header2, OneWayNode end1, OneWayNode end2) {
        //获取两个链表的长度和尾结点
        OneWayNode pointer = header1;
        int len1 = 1, len2 = 1;
        while (pointer.getNext() != end1) {
            pointer = pointer.getNext();
            ++len1;
        }
        end1 = pointer;
        pointer = header2;
        while (pointer.getNext() != end2) {
            pointer = pointer.getNext();
            ++len2;
        }
        end2 = pointer;
        //如果两个链表有交点，则尾结点必定一致
        if (end1 != end2) {
            return null;
        }
        var diff = Math.abs(len1 - len2);
        var pLong = len1 > len2 ? header1 : header2;
        var pShort = pLong == header1 ? header2 : header1;
        //两个链表剩余的长度一致
        while ((diff--) > 0) {
            pLong = pLong.getNext();
        }
        //在长度一致的情况下必然相遇点为交点
        while (pLong != pShort) {
            pLong = pLong.getNext();
            pShort = pShort.getNext();
        }
        return pLong;
    }

    /**
     * 获取两个无环链表的交点
     *
     * @param header1 无环表1
     * @param header2 无环表2
     * @return 两个链表的交点
     */
    static OneWayNode getNoLoopIntersect(OneWayNode header1, OneWayNode header2) {
        return getNoLoopIntersect(header1, header2, null, null);
    }

    /**
     * 若链表有环则第一个入环节点
     * 采用 Fast/Slow Runner 算法
     *
     * @param header 链表头部指针
     * @return 入环节点，如果无环则返回 null
     */
    static OneWayNode getLoopNode(OneWayNode header) {
        var faster = header;
        var slower = header;
        //若有环两个指针必然相遇
        while (faster != null && faster.getNext() != null) {
            slower = slower.getNext();
            faster = faster.getNext().getNext();
            if (faster == slower) {
                break;
            }
        }
        if (faster != slower) {
            return null;
        }
        //置位 faster，下次相遇节点即为入环点
        faster = header;
        while (faster != slower) {
            faster = faster.getNext();
            slower = slower.getNext();
        }
        return slower;
    }
}
