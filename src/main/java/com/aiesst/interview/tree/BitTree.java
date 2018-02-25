package com.aiesst.interview.tree;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.var;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Data
@Accessors(chain = true)
public class BitTree<T> {
    private T data;
    private BitTree<T> left;
    private BitTree<T> right;
    private Boolean isVisited = false;
    private Integer level = 0;

    /**
     * 获取树的深度
     *
     * @param tree
     * @param <R>
     * @return
     */
    public static <R> int getDepth(BitTree<R> tree) {
        if (tree == null) {
            return 0;
        }
        return Math.max(getDepth(tree.getLeft()), getDepth(tree.getRight())) + 1;
    }

    /**
     * 先序遍历二叉树
     *
     * @param tree
     * @param <R>
     */
    public static <R> void preOrderTraverse(BitTree<R> tree) {
        if (tree == null || tree.getIsVisited()) {
            return;
        }
        tree.setIsVisited(true);
        System.out.print(tree.data + "->");
        preOrderTraverse(tree.getLeft());
        preOrderTraverse(tree.getRight());
    }

    /**
     * 中序遍历二叉树
     *
     * @param tree
     * @param <R>
     */
    public static <R> void inOrderTraverse(BitTree<R> tree) {
        if (tree == null || tree.getIsVisited()) {
            return;
        }
        inOrderTraverse(tree.getLeft());
        System.out.print(tree.data + "->");
        tree.setIsVisited(true);
        inOrderTraverse(tree.getRight());
    }

    /**
     * 后续遍历二叉树
     *
     * @param tree
     * @param <R>
     */
    public static <R> void postOrderTraverse(BitTree<R> tree) {
        if (tree == null || tree.getIsVisited()) {
            return;
        }
        postOrderTraverse(tree.getLeft());
        postOrderTraverse(tree.getRight());
        tree.setIsVisited(true);
        System.out.print(tree.getData() + "->");
    }

    /**
     * 按层从上往下遍历
     *
     * @param root
     * @param <R>
     */
    public static <R> void levelTraverse(BitTree<R> root) {
        var nodes = new LinkedList<BitTree<R>>();
        nodes.add(root);
        var lastLevel = root.getLevel();
        StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append(root.getData()).append("\r\n-------------------\r\n");
        while (!nodes.isEmpty()) {
            var node = nodes.poll();
            var leftNode = node.getLeft();
            var rightNode = node.getRight();
            //判断 level 是否与上一次一致，不一致则标识该换行了
            if (leftNode != null && !leftNode.getLevel().equals(lastLevel) && lastLevel > 0) {
                stringBuilder.append("\r\n-------------------\r\n");
            } else if (rightNode != null && !rightNode.getLevel().equals(lastLevel) && lastLevel > 0) {
                stringBuilder.append("\r\n-------------------\r\n");

            }
            if (leftNode != null && !leftNode.getIsVisited()) {
                leftNode.setIsVisited(true);
                stringBuilder.append(leftNode.getData()).append(" ");
                nodes.add(leftNode);
                lastLevel = leftNode.getLevel();
            }
            if (rightNode != null && !rightNode.getIsVisited()) {
                rightNode.setIsVisited(true);
                nodes.add(rightNode);
                stringBuilder.append(rightNode.getData()).append(" ");
                lastLevel = rightNode.getLevel();
            }
        }
        System.out.println(stringBuilder);
    }

    /**
     * 检查二叉树是否平衡
     *
     * @param tree
     * @param <R>
     */
    public static <R> boolean checkTreeIsBalance(BitTree<R> tree) {
        if (getDepth(tree) == 0) {
            return true;
        }
        var diff = getDepth(tree.getRight()) - getDepth(tree.getLeft());
        return diff >= -1 && diff <= 1;
    }

    /**
     * 根据所给的数据集合，创建一颗完全二叉树
     *
     * @param dataList
     * @param <R>
     * @return
     */
    public static <R> BitTree<R> createCompleteTree(List<R> dataList) {
        var root = new BitTree<R>();
        root.setData(dataList.get(0));
        Queue<BitTree<R>> queue = new LinkedList<>();
        var count = 1;
        queue.add(root);
        while (!queue.isEmpty() && count < dataList.size()) {
            var lastNode = queue.poll();
            var level = lastNode.getLevel() + 1;
            if (count < dataList.size()) {
                var leftNode = new BitTree<R>().setData(dataList.get(count++)).setLevel(level);
                lastNode.setLeft(leftNode);
                queue.add(leftNode);
            }
            if (count < dataList.size()) {
                var rightNode = new BitTree<R>().setData(dataList.get(count++)).setLevel(level);
                lastNode.setRight(rightNode);
                queue.add(rightNode);
            }
        }
        return root;
    }

    /**
     * 创建一颗满二叉树
     *
     * @param depth 树深度
     * @return
     */
    public static BitTree<Integer> createFullTree(int depth) {
        Queue<BitTree<Integer>> queue = new LinkedList<>();
        //满二叉树的总节点个数为 2^(depth -1)
        //每一层有 2^(n-1)
        var total = Math.pow(2,depth)-1;
        var root = new BitTree<Integer>();
        int data = 1;
        root.setData(data++);
        queue.add(root);
        while (data<= total) {
            var node = queue.poll();
            var leftNode = new BitTree<Integer>().setData(data++).setLevel(node.getLevel()+1);
            var rightNode = new BitTree<Integer>().setData(data++).setLevel(node.getLevel()+1);
            node.setLeft(leftNode).setRight(rightNode);
            queue.add(leftNode);
            queue.add(rightNode);
        }
        return root;
    }
}



