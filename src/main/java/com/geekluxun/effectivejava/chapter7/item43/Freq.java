package com.geekluxun.effectivejava.chapter7.item43;

import java.util.Map;
import java.util.TreeMap;

// Frequency table implemented with map.merge, using lambda and method reference (Page 197)
public class Freq {
    public static void main(String[] args) {
        String[] args2 = {"luxun", "luxun"};

        Map<String, Integer> frequencyTable = new TreeMap<>();

        for (String s : args2)
            frequencyTable.merge(s, 1, (count, incr) -> count + incr); // Lambda
        System.out.println(frequencyTable);

        frequencyTable.clear();
        /**
         * 如果原有映射的value存在，则oldValue 和 value相加作为newValue
         */
        for (String s : args2)
            frequencyTable.merge(s, 1, Integer::sum); // Method reference
        System.out.println(frequencyTable);

    }
}
