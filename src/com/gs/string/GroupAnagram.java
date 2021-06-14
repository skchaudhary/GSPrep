package com.gs.string;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        System.out.println(group(Arrays.asList(new String[]{"cat", "dog", "god"})));
    }

    private static Set<Set<String>> group(List<String> words){
        Map<String, Set<String>> result = new HashMap<>();
        Set<Set<String>> ans = new HashSet<>();

        for (String word : words) {
            StringBuffer sb = new StringBuffer();
            int[] charCount = new int[26];
            for (char c : word.toCharArray()) {
                charCount[c-'a']++;
            }
            for (int i=0;i<26;i++) {
                sb.append(charCount[i]);
            }

            if (result.containsKey(sb.toString())) {
                result.get(sb.toString()).add(word);
            } else {
                Set<String> set = new HashSet<>();
                set.add(word);
                result.put(sb.toString(), set);
            }
        }
        for (Set<String> r : result.values()) {
            ans.add(r);
        }

        return ans;
    }

}
