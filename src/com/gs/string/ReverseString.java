package com.gs.string;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("radar"));
        System.out.println(isPalindrome("radar"));

        System.out.println(reverseStringWithSpecialCharacter("/gH?yZx"));
        System.out.println(reverseStringWithSpecialCharacter("/gH?#&yZx"));
        System.out.println(reverseStringWithSpecialCharacter("/gH?yZ&x"));
    }

    private static boolean isPalindrome(String input) {
        if (input==null) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=input.length()-1;i>=0;i--) {
            sb.append(input.charAt(i));
        }

        return input.equals(sb.toString());
    }

    private static String reverseString(String input) {
        if (input==null) {
            return input;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=input.length()-1;i>=0;i--) {
            sb.append(input.charAt(i));
        }

        return sb.toString();
    }

    private static String reverseStringWithSpecialCharacter(String input) {
        if (input==null) {
            return input;
        }

        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[input.length()];
        int end = input.length()-1;
        int i=end;
        while (i>=0) {
            int j = sb.length();
            while (j<=end && !visited[j] && isSpecialChar(input.charAt(j))) {
                sb.append(input.charAt(j));
                visited[j]=true;
                j++;
            }
            if (!isSpecialChar(input.charAt(i))) {
                sb.append(input.charAt(i));
            }
            i--;
        }

        return sb.toString();
    }

    private static boolean isSpecialChar(char c) {
        return !((c>='a' && c<='z') || (c>='A' && c<='Z'));
    }

    private static String reverseStringWithSpecialCharacter2(String input) {
        if (input==null) {
            return input;
        }

        char[] chars = input.toCharArray();
        int start = 0, end = chars.length-1;
        while (start<=end) {
            while (start<=end && isSpecialChar(chars[start])) {
                start++;
            }
            while (start<=end && isSpecialChar(chars[end])) {
                end--;
            }

            if (start<end) {
                char c = chars[start];
                chars[start]=chars[end];
                chars[end]=c;
                start++;end--;
            } else {
                start++;
            }
        }

        return String.valueOf(chars);
    }
}
