package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListInsertNumTest {

    @Test
    public void insert() {
        var header = new OneWayNode<Integer>(0);
        for (int i = 0; i < 10; i++) {
            header.push(i);
        }
        header.getTail().setNext(header);
        header.print();
        header = LinkedListInsertNum.insert(header, 0);
        header.print();
    }
}