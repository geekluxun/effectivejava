package com.geekluxun.effectivejava.chapter2.item7;

import java.util.Arrays;

// Can you spot the "memory leak"?  (Pages 26-27)

/**
 * 栈空间在伸缩的过程中需要清除过期引用，否则会导致内存泄露
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }


    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // Corrected version of pop method (Page 27)
    public Object pop2() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        /**
         * 消除过期引用，否则会内存泄露
         */
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (String arg : args)
            stack.push(arg);

        while (true)
            System.err.println(stack.pop());
    }
}
