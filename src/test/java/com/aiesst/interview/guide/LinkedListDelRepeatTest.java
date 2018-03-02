package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListDelRepeatTest {

    @Test
    public void makeUnique() {
        var header = new OneWayNode<Integer>(0);
        for (int i = 0; i < 10; i++) {
            header.push(Integer.valueOf(i));
        }
        for (int i = 0; i < 5; i++) {
            header.push(Integer.valueOf(i));
        }
        header.print();
        var pointer = header;
        header = LinkedListDelRepeat.makeUnique2(header);
        header.print();
    }
}