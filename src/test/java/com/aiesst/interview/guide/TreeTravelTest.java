package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTravelTest {

    @Test
    public void preOrderTravelByStack() {

        var array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var root = LinkedListByTreeTest.createTreeByLevel(array);
        TreeTravel.preOrderTravelByStack(root, node ->
                System.out.print(node.getData() + "->")
        );
    }
}