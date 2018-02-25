package com.aiesst.interview.guide;

import org.junit.Assert;
import org.junit.Test;

public class QueueBy2StackTest {
    @Test
    public void poll() throws Exception {
        QueueBy2Stack<Integer> queue = new QueueBy2Stack<>();
        for(int i=0;i<10;i++){
            queue.push(i);
        }

        for(int i=0;i<10;i++){
            Assert.assertEquals(queue.poll().intValue(),i);
        }
    }

}