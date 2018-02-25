package com.aiesst.interview.tree;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.corba.se.impl.orbutil.graph.Node;
import com.sun.corba.se.impl.orbutil.graph.NodeData;
import lombok.experimental.UtilityClass;
import lombok.experimental.var;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class BitTreeTest {


    /**
     * 创建一颗普通树
     * @return
     */
    BitTree<Integer> createTree() {
        BitTree<Integer> tree = new BitTree<>();
        tree.setData(0);
        BitTree<Integer> father = tree;
        for (int i = 1; i < 11; i++) {
            BitTree<Integer> pointer = new BitTree<>();
            pointer.setData(Integer.valueOf(i));
            if (i < 5) {
                father.setLeft(pointer);
                father = father.getLeft();
            } else {
                father.setRight(pointer);
                father = father.getRight();
            }
        }
        return tree;
    }


    @Test
    public void getDepth() {
        BitTree<Integer> tree = createTree();
        assertEquals(BitTree.getDepth(tree), 11);
    }

    @Test
    public void preOrderTraverseTest() {
        BitTree<Integer> tree = createTree();
        BitTree.preOrderTraverse(tree);
    }

    @Test
    public void inOrderTraverse() throws Exception {
        BitTree<Integer> tree = createTree();
        BitTree.inOrderTraverse(tree);
    }

    @Test
    public void postOrderTraverse() throws Exception {
        var tree = createTree();
        BitTree.postOrderTraverse(tree);
    }

    @Test
    public void checkTreeIsBalance() throws Exception {
        var tree =createFullTree(10);
        System.out.println(BitTree.checkTreeIsBalance(tree));
    }

    @Test
    public void createCompleteTree() throws Exception {
        List<Integer> dataList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add(i);
        }
        var tree = createCompleteTree(dataList);
        BitTree.levelTraverse(tree);
    }

    @Test
    public void levelOrderTraverse() throws Exception {
        BitTree.levelTraverse(createTree());
    }

    @Test
    public void createFullTree1() throws Exception {
        var tree =createFullTree(5);
        BitTree.levelTraverse(tree);
    }

    public static <R> BitTree createCompleteTree(List<R> dataList) {
        Queue<BitTree<R>> queue = new LinkedList<>();
        int count = 0;
        var root = new BitTree<R>().setData(dataList.get(count++)).setLevel(0);
        queue.add(root);
        while (count < dataList.size()) {
            var node = queue.poll();
            if (count < dataList.size() ) {
                var leftNode = new BitTree<R>().setData(dataList.get(count++)).setLevel(node.getLevel() + 1);
                node.setLeft(leftNode);
                queue.add(leftNode);
            }
            if (count < dataList.size()) {
                var rightNode = new BitTree<R>().setData(dataList.get(count++)).setLevel(node.getLevel() + 1);
                node.setRight(rightNode);
                queue.add(rightNode);
            }
        }
        return root;
    }
    public static BitTree<Integer> createFullTree(int depth) {
        if(depth < 1){
            return null;
        }
        var total = Math.pow(2,depth )-1;
        var count = 1;
        var root = new BitTree<Integer>().setData(count++);
        var queue = new LinkedList<BitTree<Integer>>();
        queue.add(root);
        while(count <= total) {
            var node = queue.poll();
            if(count <= total){
                var leftNode = new BitTree<Integer>().setData(count++).setLevel(node.getLevel()+1);
                node.setLeft(leftNode);
                queue.add(leftNode);
            }
            if(count <= total){
                var rightNode = new BitTree<Integer>().setData(count++).setLevel(node.getLevel()+1);
                node.setRight(rightNode);
                queue.add(rightNode);
            }
        }
        return root;
    }
}