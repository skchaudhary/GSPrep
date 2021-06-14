package com.gs.string;

public class PenGram {
    public static void main(String[] args) throws Exception {
        System.out.println("bfgjkvz".equals(findMissingLetters("The slow purple oryx meanders past the quiescent canine")));
    }

    private static String findMissingLetters(String sentence) throws Exception {
        if (sentence==null) {
            throw  new Exception("sentence is null");
        }
        sentence = sentence.toLowerCase();
        boolean[] isFound = new boolean[26];
        for (char c : sentence.toCharArray()) {
            if (c>='a' && c <= 'z' && !isFound[c-'a']) {
                isFound[c-'a'] = true;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i=0;i<26;i++) {
            if (!isFound[i]) {
                sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }
}
