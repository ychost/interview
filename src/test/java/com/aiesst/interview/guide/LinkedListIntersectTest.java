package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListIntersectTest {

    @Test
    public void getIntersectPoint() {
        var header1 = new OneWayNode<Integer>(0);
        var header2 = new OneWayNode<Integer>(0);
        for (int i = 1; i < 11; i++) {
            header1.push(i);
            if (i < 5) {
                header2.push(i);
            }
        }
        var intersect = header1.getNext().getNext().getNext().getNext();
        header2.push(intersect);
        Assert.assertEquals(intersect, LinkedListIntersect.getIntersectPoint(header1, header2));
    }

    @Test
    public void getLoopNode() {
        var header = new OneWayNode<Integer>(0);
        var loopNode = new OneWayNode<Integer>(100);
        for (int i = 1; i < 11; i++) {
            header.push(i);
            if (i == 5) {
                header.push(loopNode);
            }
        }
        header.getTail().setNext(loopNode);
        Assert.assertEquals(LinkedListIntersect.getLoopNode(header), loopNode);
    }

    @Test
    public void getNoLoopIntersect() {
        var header1 = new OneWayNode<Integer>(0);
        var header2 = new OneWayNode<Integer>(0);
        for (int i = 1; i < 11; i++) {
            header1.push(i);
            if (i < 5) {
                header2.push(i);
            }
        }
        var intersect = header1.getNext().getNext().getNext().getNext();
        header2.push(intersect);
        Assert.assertEquals(intersect, LinkedListIntersect.getNoLoopIntersect(header1, header2));
    }

    @Test
    public void getLoopIntersect() {
        var header1 = new OneWayNode<Integer>(0);
        var header2 = new OneWayNode<Integer>(0);
        for (int i = 1; i < 11; i++) {
            header1.push(i);
            if (i < 5) {
                header2.push(i);
            }
        }
        header1.print();
        header2.print();
        var intersect = header1.getNext().getNext().getNext().getNext().getNext();
        header1.getTail().setNext(intersect);
        header2.push(intersect);
        Assert.assertEquals(intersect, LinkedListIntersect.getLoopIntersect(header1, header2));
    }
}