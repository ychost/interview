package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListReverseTest {

    @Test
    public void twoWayNodeReverse() {
        var twoWayHeader = new TwoWayNode(0);
        var oneWayHeader = new OneWayNode(0);
        for (int i = 1; i < 10; i++) {
            twoWayHeader.push(i);
            oneWayHeader.push(i);
        }

        oneWayHeader = LinkedListReverse.oneWayNodeReverse(oneWayHeader);
        twoWayHeader = LinkedListReverse.twoWayNodeReverse(twoWayHeader);


        LinkedListRmrKstNode.printLinkedNode(oneWayHeader);
        LinkedListRmrKstNode.printLinkedNode(twoWayHeader);
    }

    @Test
    public void recursiveTest() {
        System.out.println(recursive(10));
    }

    public int recursive(int x) {
        if (--x == 0) {
            return x;
        }
        return recursive(x);
    }
}