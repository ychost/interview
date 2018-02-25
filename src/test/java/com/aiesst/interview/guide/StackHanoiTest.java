package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class StackHanoiTest {
    @Test
    public void hanoiRcur() throws Exception {
        var stackA = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            stackA.push(10 - i);
        }
        var hannoi = new StackHanoi<Integer>(stackA);
        hannoi.hanoiRcur();
        while (!hannoi.getStackC().isEmpty()) {
            System.out.println(hannoi.getStackC().pop());
        }
    }

}