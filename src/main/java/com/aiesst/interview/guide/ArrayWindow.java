package com.aiesst.interview.guide;

import lombok.Data;
import lombok.experimental.var;

import java.util.LinkedList;

/**
 * 《程序员代码面试指南》 窗口滑动数组
 *
 * @author ychost
 * @date 2018-2-2
 */
@Data
public class ArrayWindow {
    /**
     * 获取窗口截取状态下的最大值
     * 该方法效率很低 O(nxw)
     *
     * @param arr 整形数组
     * @param w   窗口大小
     * @return 每种窗口下的最大值
     */
    public static Integer[] getArrWindowMax(Integer[] arr, int w) {
        var res = new Integer[arr.length - w + 1];
        var i = 0;
        var resIndex = 0;
        while ((i + w) <= arr.length) {
            var max = getArrMax(arr, i, w);
            res[resIndex] = max;
            i += 1;
            resIndex += 1;
        }
        return res;
    }

    /**
     * 该方法的效率比较高 O（n)
     *
     * @param arr
     * @param w
     * @return
     */
    public static Integer[] getArrWindowMax2(Integer[] arr, int w) {
        var res = new Integer[arr.length - w + 1];
        var index = 0;
        var qMax = new LinkedList<Integer>();
        for (int i = 1; i < arr.length; i++) {
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]) {
                qMax.pollLast();
            }
            qMax.addLast(i);
            if (qMax.peekFirst() == i - w) {
                qMax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qMax.peekFirst()];
            }
        }

        return res;
    }

    /**
     * 获取数组中指定元素中的最大值
     *
     * @param arr   整形数组
     * @param start 起始索引
     * @param count 数量
     * @return 起始所有后面 count 元素中的最大值
     */
    public static Integer getArrMax(Integer[] arr, int start, int count) {
        var end = start + count;
        var max = arr[start];
        for (int i = start; i < end && i < arr.length; i++) {
            max = (arr[i] > max) ? arr[i] : max;
        }
        return max;
    }
}
