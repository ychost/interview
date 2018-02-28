package com.aiesst.interview.guide;

import lombok.Data;
import lombok.experimental.var;

import java.util.HashMap;
import java.util.Stack;

/**
 * 0. 树的节点数据结构为 Node
 * 1. 树为二叉树且没有重复元素
 * 2. 对任意子树，其最大元素都为树的头
 * 3. 实现的时间复杂度 o(N)，空间复杂度 o(N)
 *
 * @author ychost
 * @date 2018-2-11
 */
@Data
public class MaxTree {

    /**
     * 打印一颗二叉树
     *
     * @param root 树的根节点
     */
    public static void print(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue() + "->");
        print(root.getLeft());
        print(root.getRight());
    }


    /**
     * 校验一棵树
     *
     * @param root 树的根节点
     * @return 校验结果
     */
    public static boolean validTree(Node root) {
        return root == null || validNode(root) && validTree(root.getLeft()) && validTree(root.getRight());
    }

    /**
     * 校验其中某一个节点
     *
     * @param node 节点
     * @return 校验结果
     */
    private static boolean validNode(Node node) {
        return null == node || (node.getLeft() == null || node.getLeft().getValue() <= node.getValue()) && (node.getRight() == null || node.getRight().getValue() <= node.getValue());
    }

    /**
     * 通过数组生成 MaxTree
     *
     * @param arr 没有重复元素的数组
     * @return MaxTree 的头部元素
     */
    static Node generate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        var nodeArr = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodeArr[i] = new Node(arr[i]);
        }
        var lBigNodeMap = new HashMap<Node, Node>();
        var rBigNodeMap = new HashMap<Node, Node>();
        var stack = new Stack<Node>();
        //填充 lBigNodeMap
        for (Node node : nodeArr) {
            while ((!stack.isEmpty()) && stack.peek().getValue() < node.getValue()) {
                popStackSetMap(lBigNodeMap, stack);
            }
            stack.push(node);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(lBigNodeMap, stack);
        }

        //填充 rBigNodeMap
        for (int i = nodeArr.length - 1; i >= 0; i--) {
            var node = nodeArr[i];
            while ((!stack.isEmpty()) && stack.peek().getValue() < node.getValue()) {
                popStackSetMap(rBigNodeMap, stack);
            }
            stack.push(node);

        }
        while (!stack.isEmpty()) {
            popStackSetMap(rBigNodeMap, stack);
        }

        //生成 MaxTree
        Node root = null;
        for (Node node : nodeArr) {
            var left = lBigNodeMap.get(node);
            var right = rBigNodeMap.get(node);
            //根节点
            if (left == null && right == null) {
                root = node;
                //只有右边较大元素
            } else if (left == null) {
                if (right.getLeft() == null) {
                    right.setLeft(node);
                } else {
                    right.setRight(node);
                }
                //只有左边较大元素
            } else if (right == null) {
                if (left.getLeft() == null) {
                    left.setLeft(node);
                } else {
                    left.setRight(node);
                }
                //左右均有较大元素，则选取较小的那个
            } else {
                var parent = left.getValue() < right.getValue() ? left : right;
                if (parent.getLeft() == null) {
                    parent.setLeft(node);
                } else {
                    parent.setRight(node);
                }
            }
        }
        return root;
    }

    /**
     * 从 stack 中弹出元素到 map 中
     *
     * @param map
     * @param stack
     */
    private static void popStackSetMap(HashMap<Node, Node> map, Stack<Node> stack) {
        var popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }
}

/**
 * MaxTree 的节点数据结构
 */
@Data
class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int data) {
        this.value = data;
    }
}
