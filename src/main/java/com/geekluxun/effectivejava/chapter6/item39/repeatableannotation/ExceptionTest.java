package com.geekluxun.effectivejava.chapter6.item39.repeatableannotation;

import java.lang.annotation.*;

/**
 * 可重复注解
 */
// Repeatable annotation type (Page 186)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}