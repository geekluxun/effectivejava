package com.geekluxun.effectivejava.chapter2.item6;

// Hideously slow program! Can you spot the object creation? (Page 24)
public class Sum {
    private static long sum() {
        /**
         * 这里计算的时候涉及到装箱拆箱的过程，比较昂贵
         */
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        int numSets = Integer.parseInt(args[0]);
        long x = 0;

        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            x += sum();
            long end = System.nanoTime();
            System.out.println((end - start) / 1_000_000. + " ms.");
        }

        // Prevents VM from optimizing away everything.
        if (x == 42)
            System.out.println();
    }
}