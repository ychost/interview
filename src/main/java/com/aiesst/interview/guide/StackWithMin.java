package com.aiesst.interview.guide;

import lombok.Data;
import lombok.experimental.var;

import java.util.Stack;

@Data
@SuppressWarnings("unchecked")
public class StackWithMin<T extends Comparable> {
    private T[] dataArray;
    private Stack<T> minStack;
    private int capacity;
    private int count;
    private double factory = 0.8;
    private T min;

    public StackWithMin(int capacity) {
        this.capacity = capacity;
        dataArray = (T[]) new Comparable[capacity];
        minStack = new Stack<>();
    }


    /**
     * 放入元素的时候赋值最小值
     *
     * @param data
     */
    synchronized void push(T data) {
        if (count >= dataArray.length * factory) {
            T[] newCollection = (T[]) new Comparable[count + capacity];
            System.arraycopy(dataArray, 0, newCollection, 0, count);
            dataArray = newCollection;
        }

        if (count == 0 || minStack.peek().compareTo(data) >= 0) {
            minStack.push(data);
        }
        dataArray[count++] = data;
    }

    /**
     * @return
     */
    synchronized T pop() {
        var data = dataArray[count - 1];
        dataArray[count - 1] = null;
        count--;
        if (data.compareTo(minStack.peek()) == 0) {
            minStack.pop();
        }
        return data;
    }


    /**
     * 获取最小值
     *
     * @return
     */
    synchronized T getMin() {
        return minStack.peek();
    }

    synchronized T peek() {
        return dataArray[count - 1];
    }
}
