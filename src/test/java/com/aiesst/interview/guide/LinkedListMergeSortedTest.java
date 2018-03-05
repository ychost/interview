package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListMergeSortedTest {

    @Test
    public void merge() {
        var header1 = new OneWayNode<Integer>(0);
        var header2 = new OneWayNode<Integer>(0);
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                header1.push(10 - i);
            } else {
                header2.push(i);
            }
        }
        header1.print();
        header2.print();
        var header = LinkedListMergeSorted.merge(header1, header2);
        header.print();
    }
}