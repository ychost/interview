package com.aiesst.interview.guide;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListJosephusTest {

    @Test
    public void getAliveNode() {
        OneWayNode oneWayHeader = new OneWayNode(1);
        OneWayNode oneWayHeader2 = new OneWayNode(1);
        for (int i = 2; i < 100; i++) {
            oneWayHeader.push(i);
            oneWayHeader2.push(i);
        }
        oneWayHeader = LinkedListJosephus.getAliveNode(oneWayHeader, 3);
        oneWayHeader2 = LinkedListJosephus.getAliveNode2(oneWayHeader2, 3);
        Assert.assertEquals((int) oneWayHeader.getData(), (int) oneWayHeader2.getData());
        oneWayHeader.print();
        oneWayHeader2.print();
    }
}