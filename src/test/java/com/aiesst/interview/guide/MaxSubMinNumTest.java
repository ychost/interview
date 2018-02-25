package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Test;

public class MaxSubMinNumTest {

    @Test
    public void getSubMinNum() {
        var arr = new int[]{0,10,11};
        var nums = MaxSubMinNum.getSubMinNum(arr,0);
        System.out.println(nums);
    }
}