package com.geekluxun.effectivejava.chapter5.item30;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

// Using a recursive type bound to express mutual comparability (Pages 137-8)

/**
 * 获取一个集合中的最大值，集合中的元素E的界限是实现Comparable接口，即和自身能比较
 */
public class RecursiveTypeBound {
    // Returns max value in a collection - uses recursive type bound

    /**
     * 这里使用"E extends Comparable<E>",是为了要求元素E是可比较的
     *
     * @param c
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E >> E max(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("Empty collection");

        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return result;
    }

    public static void main(String[] args) {
        List<String> argList = Arrays.asList("1", "3", "8", "2", "5");
        System.out.println(max(argList));
    }
}