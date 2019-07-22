package com.geekluxun.effectivejava.chapter6.item40;

import java.util.HashSet;
import java.util.Set;

// Can you spot the bug? (Page 188)
public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    /**
     * 此处漏了@override，导致Set在判断元素相等的时候没有调用此方法，而是从Object继承的equals方法，
     * Object的equals方式等同于==，是引用相同的意思
     * @param b
     * @return
     */
    public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++)
            for (char ch = 'a'; ch <= 'z'; ch++)
                s.add(new Bigram(ch, ch));
        System.out.println(s.size());
    }
}
