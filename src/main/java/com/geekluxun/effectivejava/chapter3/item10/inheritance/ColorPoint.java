package com.geekluxun.effectivejava.chapter3.item10.inheritance;


import com.geekluxun.effectivejava.chapter3.item10.Color;
import com.geekluxun.effectivejava.chapter3.item10.Point;

import java.security.Timestamp;

// Attempting to add a value component to Point (Page 41)

/**
 * 使用继承的方式增加新的特性
 */
public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    // Broken - violates symmetry!  (Page 41)

    /**
     * 违反了对称性
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        return super.equals(o) && ((ColorPoint) o).color == color;
    }


    /**
     * 违反了传递性
     *
     * @param args
     */
//    // Broken - violates transitivity! (page 42)
//    @Override public boolean equals(Object o) {
//        if (!(o instanceof Point))
//            return false;
//
//        // If o is a normal Point, do a color-blind comparison
//        if (!(o instanceof ColorPoint))
//            return o.equals(this);
//
//        // o is a ColorPoint; do a full comparison
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }
    public static void main(String[] args) {
        // First equals function violates symmetry (Page 42)
        /**
         * 违反了对称性
         */
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println(p.equals(cp) + " " + cp.equals(p));

        // Second equals function violates transitivity (Page 42)
        /**
         * 违反了传递性
         */
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.printf("%s %s %s%n",
                p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }
}
