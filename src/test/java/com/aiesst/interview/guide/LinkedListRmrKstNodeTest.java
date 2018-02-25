package com.aiesst.interview.guide;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListRmrKstNodeTest {

    @Test
    public void rmsKstOneWayNode() {
        OneWayNode oneWayHeader = new OneWayNode(0);
        TwoWayNode twoWayHeader = new TwoWayNode(0);
        for (int i = 1; i < 10; i++) {
            oneWayHeader.push(i);
            twoWayHeader.push(i);
        }
        LinkedListRmrKstNode.printLinkedNode(oneWayHeader);
        LinkedListRmrKstNode.printLinkedNode(twoWayHeader);

        oneWayHeader = LinkedListRmrKstNode.rmsKstOneWayNode(oneWayHeader, 10);
        LinkedListRmrKstNode.printLinkedNode(oneWayHeader);

        twoWayHeader = LinkedListRmrKstNode.rmsKstTwoWayNode(twoWayHeader, 10);
        LinkedListRmrKstNode.printLinkedNode(twoWayHeader);
    }


}