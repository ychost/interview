package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayWindowTest {
    @Test
    public void getArrWindowMax() throws Exception {
        var arr = new Integer[]{4, 3, 5, 4, 3, 3, 6, 7};
        var res = ArrayWindow.getArrWindowMax(arr, 1);
        Assert.assertEquals(res[0].intValue(),4);
        Assert.assertEquals(res[1].intValue(),3);
        Assert.assertEquals(res[2].intValue(),5);
        Assert.assertEquals(res[3].intValue(),4);
        Assert.assertEquals(res[4].intValue(),3);
        Assert.assertEquals(res[5].intValue(),3);
    }

}