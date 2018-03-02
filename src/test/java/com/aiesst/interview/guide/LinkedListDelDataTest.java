package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Test;

public class LinkedListDelDataTest {

    @Test
    public void delData() {
        var header = new OneWayNode<Integer>(0);
        for (int i = 0; i < 10; i++) {
            header.push(i);
            header.push(i);
        }
        header.push(0).push(1);
        header.print();
        header = MaxSubMinNum.LinkedListDelData.delData(header,1);
        header.print();
    }
}