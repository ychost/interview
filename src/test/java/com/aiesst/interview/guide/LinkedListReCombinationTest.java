package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListReCombinationTest {

    @Test
    public void combination() {
        var header = new OneWayNode<Integer>(0).push(1).push(2).push(3);

        header.print();
        header = LinkedListReCombination.combination(header);
        header.print();

    }

    @Test
    public void math() {
        var a = Math.floor(3.0);
        var b = Math.cbrt(3.0);
    }

}