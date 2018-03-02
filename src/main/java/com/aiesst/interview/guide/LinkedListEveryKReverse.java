package com.aiesst.interview.guide;

import lombok.experimental.var;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将单链表的每 K 个节点逆序
 *
 * @author ychots
 * @date 2018-3-2
 */
public class LinkedListEveryKReverse {
    /**
     * 每 K 个节点逆序，最后不足 K 个节点则不进行操作
     * 比如：1->2->3->4->5  K = 2
     * 则：2->1->4->3->5
     * 该方法是将原链表进行反转，然后每 K 个长度的节段放入队列中
     * 从队列中一一取出然后进行拼接即可
     *
     * @param header 单链表的头指针
     * @param k      每次需要逆序的节点数
     * @return 逆序后的头指针
     */
    static OneWayNode reverseEveryK(OneWayNode header, int k) {
        var len = 0;
        var pointer = header;
        while (pointer != null) {
            ++len;
            pointer = pointer.getNext();
        }
        if (len < k || k <= 1) {
            return header;
        }
        pointer = header;
        var queue = new LinkedList<OneWayNode>();
        OneWayNode next, pre = null;
        //将链表没 k 个为一组进行反转
        //然后将每组存队列里
        int i = 0, times = len / k;
        while (pointer.getNext() != null && times > 0) {
            next = pointer.getNext();
            pointer.setNext(pre);
            pre = pointer;
            pointer = next;
            //反转过的部分
            if (++i == k) {
                i = 0;
                --times;
                queue.add(pre);
                pre = null;
            }
            //未反转的部分
            if (times == 0) {
                queue.add(pointer);
            }
        }
        //从队列取出反转的每段然后进行拼接
        OneWayNode rePointer = null, reHeader = null;
        while (!queue.isEmpty()) {
            var node = queue.pop();
            if (rePointer != null) {
                //拼接
                while (rePointer.getNext() != null) {
                    rePointer = rePointer.getNext();
                }
                rePointer.setNext(node);
            } else {
                reHeader = node;
            }
            rePointer = node;
        }
        return reHeader;
    }
}
