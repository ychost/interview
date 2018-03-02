package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Test;

public class LinkedListSelectedSortTest {

    @Test
    public void deleteNode() {
        var oneWayHeader = new OneWayNode<Integer>(0);
        for (int i = 0; i < 10; i++) {
            oneWayHeader.push(i);
        }
        var node = new OneWayNode<Integer>(9);
        oneWayHeader.push(node);
        oneWayHeader.print();
        LinkedListSelectedSort.deleteNode(oneWayHeader, node);
        oneWayHeader.print();
    }

    @Test
    public void sort() {
        var oneWayHeader = new OneWayNode<Integer>(9).push(3).push(10).push(1).push(2).push(8);
        oneWayHeader.print();
        oneWayHeader = LinkedListSelectedSort.sort(oneWayHeader);
        oneWayHeader.print();
    }
}