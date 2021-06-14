package com.gs.string;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(findFirst("apple")=='a');
        System.out.println(findFirst("xxyyzz")=='0');
    }

    private static char findFirst(String input){
        if (input==null || input.length()==0) {
            return '0';
        }

        int[] charCount = new int[26];

        for (char c : input.toCharArray()) {
            charCount[c-'a']++;
        }

        for (char c : input.toCharArray()) {
            if (charCount[c-'a']==1) {
                return c;
            }
        }

        return '0';
    }
}
