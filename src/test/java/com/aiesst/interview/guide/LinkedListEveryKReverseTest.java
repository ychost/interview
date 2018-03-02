package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListEveryKReverseTest {

    @Test
    public void reverseEveryK() {
        var header = new OneWayNode<Integer>(0);
        for (int i = 1; i <= 10; i++) {
            header.push(i);
        }
        header.print();
        header = LinkedListEveryKReverse.reverseEveryK(header, 2);
        header.print();

    }
}