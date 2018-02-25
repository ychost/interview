package com.aiesst.interview.guide;

import org.junit.Test;

import java.util.Random;
import java.util.Stack;

import static org.junit.Assert.*;

public class StackSortTest {
    @Test
    public void sortByStack() throws Exception {
        Stack<Integer> stack = new Stack<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            stack.push(random.nextInt(100));
        }
        stack = StackSort.sortByStack(stack);
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }
    }

}