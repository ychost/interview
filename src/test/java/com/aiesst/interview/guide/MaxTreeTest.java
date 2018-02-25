package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTreeTest {

    @Test
    public void generate() {
        var arr = new int[]{4,10,3,0,1,2};
        var tree = MaxTree.generate(arr);
        System.out.println(MaxTree.validTree(tree));
    }
}