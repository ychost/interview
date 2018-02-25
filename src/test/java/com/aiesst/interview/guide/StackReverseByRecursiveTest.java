package com.aiesst.interview.guide;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class StackReverseByRecursiveTest {
    @Test
    public void reverse() throws Exception {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        StackReverse.reverse(stack);
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(stack.pop().intValue(), i);
        }
    }

}