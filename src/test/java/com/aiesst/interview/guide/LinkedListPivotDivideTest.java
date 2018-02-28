package com.aiesst.interview.guide;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListPivotDivideTest {

    @Test
    public void divide() {
        OneWayNode<Integer> header = new OneWayNode<>(0).push(3).push(7).push(2).push(6).push(1).push(10);
        header.print();
        header = LinkedListPivotDivide.divide(header, 5);
        header.print();
    }
}