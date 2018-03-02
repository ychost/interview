package com.aiesst.interview.guide;

import lombok.experimental.var;

import java.util.LinkedList;

/**
 * 给定一数组求其中子数组的最大值减去最小值 <= Num 的子数组数量
 * 要求时间复杂度为 o(N)
 *
 * @author ychost
 * @date 2018-2-16
 */
public class MaxSubMinNum {
    /**
     * 获取子数组中最大值减去最小值 <= num 的子数组的数量
     *
     * @param arr 待处理数组
     * @param num 比较数字
     * @return 子数组的数量
     */
    static int getSubMinNum(int[] arr, int num) {
        var qmax = new LinkedList<Integer>();
        var qmin = new LinkedList<Integer>();
        var i = 0;
        var j = 0;
        var res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                //维护最大值
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                //维护最小值
                while (!qmax.isEmpty() && arr[qmax.pollLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                //某一 arr[i..j] 不满足情况，停止 j 的扩张
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            //因为后面有 i++ 所以 arr[i] 已经不能用作最值比较了
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            //arr[i..j] 的所有子数组都满足
            res += j - i;
            i++;
        }
        return res;
    }

    /**
     * 暴力解法，只是用来验证结果
     *
     * @param arr
     * @param num
     * @return
     */
    static int getSubMinNum2(int[] arr, int num) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int max = i;
                int min = i;
                for (int k = i; k <= j; k++) {
                    if (arr[k] > arr[max]) {
                        max = k;
                    }
                    if (arr[k] < arr[min]) {
                        min = k;
                    }
                }
                if (arr[max] - arr[min] <= num) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 在单链表中删除指定节点 ☆
     *
     * @author ychost
     * @date 2018-3-2
     */
    public static class LinkedListDelData {
        /**
         * 删除值为data的节点
         *
         * @param header 单链表头指针
         * @param data   删除的节点值
         * @return 删除节点后的头指针
         */
        static OneWayNode delData(OneWayNode header, Object data) {
            var pointer = header;
            OneWayNode pre = null;
            while (pointer != null) {
                var next = pointer.getNext();
                if (pointer.getData().equals(data)) {
                    if (pre != null) {
                        pre.setNext(next);
                    }
                    pointer.setNext(null);
                } else {
                    if (pre == null) {
                        header = pointer;
                    }
                    pre = pointer;
                }
                pointer = next;
            }
            return header;
        }
    }
}

