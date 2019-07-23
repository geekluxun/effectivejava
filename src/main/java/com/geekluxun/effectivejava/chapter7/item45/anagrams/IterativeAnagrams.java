package com.geekluxun.effectivejava.chapter7.item45.anagrams;

import java.io.File;
import java.io.IOException;
import java.util.*;

// Prints all large anagram groups in a dictionary iteratively (Page 204)
public class IterativeAnagrams {
    public static void main(String[] args) throws IOException {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                /**
                 *  if (map.get(key) == null) {
                 *      V newValue = mappingFunction.apply(key);
                 *      if (newValue != null)
                 *          map.put(key, newValue);
                 *  }
                 * 
                 */
                groups.computeIfAbsent(alphabetize(word),
                        (unused) -> new TreeSet<>()).add(word);
            }
        }

        for (Set<String> group : groups.values())
            if (group.size() >= minGroupSize)
                System.out.println(group.size() + ": " + group);
    }

    /**
     * 按字母序排列
     * @param s
     * @return
     */
    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
