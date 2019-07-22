package com.geekluxun.effectivejava.chapter2.item4;

// Noninstantiable utility class (Page 19)
public class UtilityClass {
    // Suppress default constructor for noninstantiability

    /**
     * 工具类不允许被实例化
     */
    private UtilityClass() {
        throw new AssertionError();
    }

    // Remainder omitted
}
