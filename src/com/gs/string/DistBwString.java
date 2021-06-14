package com.gs.string;

public class DistBwString {
    public static void main(String[] args) {
        String document = "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements.";

        System.out.println(shortestDistance( document, "is", "a" ) == 2.5);

    }

    public static double shortestDistance(String document, String word1, String word2) {
        String[] words = document.split("[., ]");
        double shortest = document.length();
        double word1Index = 0;
        double word2Index=0;
        int index=0;

        for (String word : words) {
            if (word.equalsIgnoreCase(word1)) {
                word1Index = index + word.length()/2.0;
            } else if (word.equalsIgnoreCase(word2)) {
                word2Index = index + word.length()/2.0;
            }

            if (word1Index>0 && word2Index>0) {
                double current = word2Index - word1Index;
                if (current<shortest) {
                    shortest = current;
                }
            }

            index += word.length() + 1;
        }

        if (word1Index==0 || word2Index==0) {
            return -1;
        }

        return shortest;
    }
}
