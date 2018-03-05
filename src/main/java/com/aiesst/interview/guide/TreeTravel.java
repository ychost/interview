package com.aiesst.interview.guide;

import lombok.experimental.var;

import java.util.Stack;
import java.util.function.Consumer;

/**
 * 二叉树的遍历 ☆☆☆
 *
 * @author ychost
 * @date 2018-3-5
 */
public class TreeTravel {

    /**
     * 非递归先序遍历二叉树
     *
     * @param root 二叉树根节点
     */
    static void preOrderTravelByStack(BinTreeNode root, Consumer<BinTreeNode> action) {
        var stack = new Stack<BinTreeNode>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                var node = stack.pop();
                if (action != null) {
                    action.accept(node);
                }
                if (node.getRight() != null) {
                    stack.push(node.getRight());
                }
                if (node.getLeft() != null) {
                    stack.push(node.getLeft());
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归中序遍历二叉树
     *
     * @param root 二叉树根节点
     */
    static void inOrderTravelByStack(BinTreeNode root, Consumer<BinTreeNode> action) {

    }

}
