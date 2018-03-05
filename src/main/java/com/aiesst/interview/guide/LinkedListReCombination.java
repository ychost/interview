package com.aiesst.interview.guide;

import lombok.experimental.var;

/**
 * 按左右半区方式重新组合链表 ☆
 *
 * @author ychost
 * @date 2018-3-5
 */
public class LinkedListReCombination {
    /**
     * 原链表 L1->L2->..->R1->R2
     * 变为 L1->R1->L2->R2->...
     * 注释：如果长度为 奇数 则 R 部分多一个
     *
     * @param header 单链表头指针
     * @return 重组后的链表头指针
     */
    static OneWayNode combination(OneWayNode header) {
        var len = 0;
        var pointer = header;
        //找到长度
        while (pointer != null) {
            ++len;
            pointer = pointer.getNext();
        }
        int lEnd = len / 2;
        var i = 0;
        pointer = header;
        //找到 R1
        while (i != lEnd) {
            ++i;
            pointer = pointer.getNext();
        }
        var lPointer = header;
        var rPointer = pointer;
        pointer = null;
        i = 0;
        //拼接
        while (i++ != lEnd) {
            var lNext = lPointer.getNext();
            var rNext = rPointer.getNext();
            if (pointer !=null){
                pointer.setNext(lPointer);
            }
            lPointer.setNext(null);
            pointer = lPointer;

            pointer.setNext(rPointer);
            rPointer.setNext(null);
            pointer = rPointer;

            lPointer = lNext;
            rPointer = rNext;
        }
        //续接 RN （如果长度为奇数的情况）
        if (rPointer != null && pointer != null) {
            pointer.setNext(rPointer);
            rPointer.setNext(null);
        }
        return header;
    }
}
