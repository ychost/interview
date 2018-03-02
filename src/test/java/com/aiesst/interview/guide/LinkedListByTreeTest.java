package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class LinkedListByTreeTest {

    @Test
    public void convert() {
        var array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        var tree = LinkedListByTreeTest.createTreeByLevel(array);
        tree.print();
        var twoWayHeader = LinkedListByTree.convert(tree);
        twoWayHeader.print();

    }

    static <T> BinTreeNode<T> createTreeByLevel(T[] array) {
        BinTreeNode<T> root = new BinTreeNode<>(array[0]);
        var queue = new LinkedList<BinTreeNode<T>>();
        queue.add(root);
        int i;
        for (i = 1; i < array.length - 1; i += 2) {
            var left = new BinTreeNode<T>(array[i]);
            var right = new BinTreeNode<T>(array[i + 1]);
            var father = queue.poll();
            father.setLeft(left);
            father.setRight(right);
            queue.add(left);
            queue.add(right);
        }
        if (i == array.length - 1) {
            queue.poll().setLeft(new BinTreeNode<>(array[array.length - 1]));
        }
        return root;
    }

    @Test
    public void treeToQueue() {
        var array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        var tree = LinkedListByTreeTest.createTreeByLevel(array);
        var queue = LinkedListByTree.treeToQueue(tree);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll().getData() + " ");
        }
    }
}