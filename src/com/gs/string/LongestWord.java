package com.gs.string;

import java.util.*;

public class LongestWord {
    public static void main(String[] args) {
        List<String> dict = new ArrayList<>(Arrays.asList(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"}));

        System.out.println(longestWord("toe", dict).toString());
        System.out.println(longestWord("oetdg", dict).toString());
    }

    private static Set<String> longestWord(String letters, List<String> dictionary) {
        Set<String> result = new HashSet<>();
        if (letters==null || letters.length()==0) {
            return result;
        }
        Set<Character> letterSet = new HashSet<>();
        for (char c : letters.toCharArray()) {
            letterSet.add(c);
        }

        int wordLength = 0;
        for (String word: dictionary) {
            boolean isWordCanBeFormed = true;
            for (char c: word.toCharArray()) {
                if (letterSet.contains(c)) {
                    continue;
                } else {
                    isWordCanBeFormed = false;
                    break;
                }
            }

            if (isWordCanBeFormed) {
                if (word.length()>wordLength) {
                    result = new HashSet<>();
                    wordLength = word.length();
                }
                result.add(word);
            }
        }

        return result;
    }

}
