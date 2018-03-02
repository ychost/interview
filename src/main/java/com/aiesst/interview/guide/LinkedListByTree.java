package com.aiesst.interview.guide;

import lombok.Data;
import lombok.experimental.var;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 将搜索二叉树转换成双向链表 ☆☆
 *
 * @author ychost
 * @date 2018-3-2
 */
public class LinkedListByTree {
    /**
     * tree 的 left  指针为链表的 pre
     * tree 的 right 指针为链表的 next
     *
     * @param root 二叉树的头指针
     * @return 转成的双向链表头指针
     */
    static TwoWayNode convert(BinTreeNode root) {
        Queue<BinTreeNode> queue = treeToQueue(root);
        var header = new TwoWayNode(queue.poll().getData());
        TwoWayNode pre = header;
        while (!queue.isEmpty()) {
            var node = new TwoWayNode(queue.poll().getData());
            pre.setNext(node);
            node.setPrevious(pre);
            pre = node;
        }
        return header;
    }

    /**
     * 将一个二叉树按分层遍历的顺序放入队列中
     *
     * @param root 二叉树根节点
     * @param <T>  二叉树节点数据类型
     * @return 队列的头指针
     */
    static <T> Queue<BinTreeNode<T>> treeToQueue(BinTreeNode<T> root) {
        var queue = new LinkedList<BinTreeNode<T>>();
        var visit = new LinkedList<BinTreeNode<T>>();
        visit.add(root);
        while (!visit.isEmpty()) {
            var node = visit.poll();
            queue.add(node);
            var left = node.getLeft();
            var right = node.getRight();
            if (left != null) {
                visit.add(left);
            }
            if (right != null) {
                visit.add(right);
            }
        }
        return queue;
    }
}

/**
 * 二叉树数据结构
 *
 * @param <T>
 */
@Data
class BinTreeNode<T> {
    private T data;
    private BinTreeNode<T> left;
    private BinTreeNode<T> right;

    public BinTreeNode(T data) {
        this.data = data;
    }

    void print() {
        var queue = new LinkedList<BinTreeNode<T>>();
        var root = this;
        queue.add(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            var leftNode = node.getLeft();
            var rightNode = node.getRight();
            System.out.print(node.getData() + " ");
            if (leftNode != null) {
                queue.add(leftNode);
            }
            if (rightNode != null) {
                queue.add(rightNode);
            }
        }
        System.out.println();
    }
}
