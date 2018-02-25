package com.aiesst.interview.guide;

import lombok.experimental.var;

import java.util.Stack;

/**
 * 输入：
 * 一个只有0,1两种元素组成的矩阵
 * 输出：
 * 一个只含有 1 的最大子矩阵的 1 的个数
 *
 * @author ychost
 * @date 2018-2-12
 */
public class MaxSubmatrix {

    /**
     * 解题算法
     *
     * @param matrix 只含有 1，0两种元素组成的矩阵
     * @return 只含有1的最大子矩阵中1的个数
     */
    static int getMaxSubmatrixArea(int[][] matrix) {
        //切割矩阵
        var heightArr = cutMatrix(matrix);
        var stack = new Stack<Integer>();
        var max = 0;
        for (var i = 0; i < heightArr.length; i++) {
            //获取每行切割高度扩展的最大矩形区域面积
            //只有当栈顶元素 < 当前元素 才进行压栈
            //否则弹出栈顶元素，并计算其扩展的最大矩形区域面积
            for (var j = 0; j < heightArr[i].length; j++) {
                var height = heightArr[i];
                while (!stack.isEmpty() && height[stack.peek()] >= height[j]) {
                    var size = popStackGetMaxRecArea(stack, height, j);
                    max = size > max ? size : max;
                }
                stack.push(j);
            }
            while (!stack.isEmpty()) {
                var size = popStackGetMaxRecArea(stack, heightArr[i], heightArr[0].length);
                max = size > max ? size : max;
            }
        }
        return max;
    }

    /**
     * 从栈中弹出元素，并获取该元素能够扩展的最大矩形区域的面积
     *
     * @param stack  存有「height 索引」的栈
     * @param height 矩阵切割的某行的高度
     * @param i      待压如栈顶的元素的索引
     * @return 扩展的最大矩形区域面积
     */
    static int popStackGetMaxRecArea(Stack<Integer> stack, int[] height, int i) {
        var j = stack.pop();
        var k = -1;
        if (!stack.isEmpty()) {
            k = stack.peek();
        }
        //弹出元素对应的面积
        return (i - k - 1) * height[j];
    }

    /**
     * 将矩阵进行切割，找出从第0行到切割行之间连续「1」的个数
     *
     * @param matrix 矩阵
     * @return 连续为「1」的个数为元素的数组
     */
    static int[][] cutMatrix(int[][] matrix) {
        var heightArr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    heightArr[i][j] = matrix[i][j];
                } else {
                    heightArr[i][j] = matrix[i][j] == 0 ? 0 : heightArr[i - 1][j] + 1;
                }
            }
        }
        return heightArr;
    }
}
