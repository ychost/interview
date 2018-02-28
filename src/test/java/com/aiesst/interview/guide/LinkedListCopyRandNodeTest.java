package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class LinkedListCopyRandNodeTest {

    @Test
    public void copy() {
        var header = new RandNode<Integer>(0);
        var pointer = header;
        var nodeArr = (RandNode<Integer>[]) new RandNode[10];
        for (int i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = new RandNode<>(i + 1);
            pointer.setNext(nodeArr[i]);
            pointer = nodeArr[i];
        }
        //数组洗牌
        var r = new Random();
        for (int i = nodeArr.length - 1; i >= 1; i--) {
            int j = r.nextInt(i);
            var t = nodeArr[i];
            nodeArr[i] = nodeArr[j];
            nodeArr[j] = t;
        }
        //设置随机连接
        header.setRand(nodeArr[0]);
        for (int i = 0; i < nodeArr.length - 1; i++) {
            nodeArr[i].setRand(nodeArr[i + 1]);
        }
        var copyPointer = LinkedListCopyRandNode.copyEff(header);
        pointer = header;
        //校验
        while (copyPointer != null) {
            Assert.assertEquals(pointer.getData(), copyPointer.getData());
            Assert.assertNotEquals(pointer, copyPointer);

            if (pointer.getRand() != null) {
                Assert.assertEquals(pointer.getRand().getData(), copyPointer.getRand().getData());
                Assert.assertNotEquals(pointer.getRand(), copyPointer.getRand());
            }
            copyPointer = copyPointer.getNext();
            pointer = pointer.getNext();
        }
    }
}