package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSubmatrixTest {

    @Test
    public void getMaxSubmatrixArea() {
        var matrix = new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0},
        };
        var size = MaxSubmatrix.getMaxSubmatrixArea(matrix);
        System.out.println(size);
    }
}