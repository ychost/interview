package com.aiesst.interview.guide;

import lombok.experimental.var;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListIsPalindromeTest {

    @Test
    public void isPalindrome() {
        var oneWayHeader = new OneWayNode(1).push(1).push(2).push(1).push(1);
        Assert.assertEquals(LinkedListIsPalindrome.isPalindrome(oneWayHeader), LinkedListIsPalindrome.isPalindrome2(oneWayHeader));
    }

    @Test
    public void reverseLinkedList() {
        var oneWayHeader = new OneWayNode(0);
        for (int i = 1; i < 10; i++) {
            oneWayHeader.push(i);
        }
        oneWayHeader = LinkedListIsPalindrome.reverseLinkedList(oneWayHeader);
        oneWayHeader.print();
    }
}