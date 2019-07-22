package com.geekluxun.effectivejava.chapter3.item10.composition;


import com.geekluxun.effectivejava.chapter3.item10.Color;
import com.geekluxun.effectivejava.chapter3.item10.Point;

import java.util.Objects;

// Adds a value component without violating the equals contract (page 44)

/**
 * 使用组合的方式增加新的特性
 */
public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     * Returns the point-view of this color point.
     */
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    @Override
    public int hashCode() {
        return 31 * point.hashCode() + color.hashCode();
    }

    public static void main(String[] args) {
        /**
         * 这里是使用组合的方式，所以Point和ColorPoint是不等的
         */
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println(p.equals(cp) + " " + cp.equals(p));
    }
}