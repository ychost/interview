package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class StackWithMinTest {
    @Test
    public void push() throws Exception {
        var stack = new StackWithMin<Integer>(20);

        var rand = new Random();
        for (int i = 0; i < 100; i++) {
            stack.push(rand.nextInt(100));
            if (i == 50) {
                stack.push(-100);
            }
        }
        Assert.assertEquals(stack.getMin().longValue(),-100);
        for(int i=0;i<100;i++){
            stack.pop();
            System.out.println(stack.getMin());
        }
    }

    @Test
    public void pop() throws Exception {
    }

    @Test
    public void getMin() throws Exception {
    }

}