package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Test;

public class LinkedListAddTest {

    @Test
    public void add() {
        OneWayNode<Integer> header1 = new OneWayNode<>(9).push(3).push(6);
        OneWayNode<Integer> header2 = new OneWayNode<>(6).push(4);
        var sum = LinkedListAdd.add(header1, header2);
        sum.print();
    }
}