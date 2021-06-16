package com.gs.miscllaneous;

public class LengthOfCycle {
    public static void main(String[] args) {
        System.out.println(countLengthOfCycle(new int[]{1, 0}, 0));
        System.out.println(countLengthOfCycle(new int[]{1, 2, 0}, 0));
        System.out.println(countLengthOfCycle(new int[]{1, 2, 3}, 0));
    }

    private static int countLengthOfCycle(int[] arr, int startIndex){
        if (startIndex>=arr.length) {
            return -1;
        }

        int N = arr.length;
        boolean[] visited = new boolean[N];
        int current = startIndex;
        int c=0;
        while (!visited[current]) {
            visited[current]=true;
            current = arr[current];
            if (current>=N) {
                return -1;
            }
            c++;
        }

        return c;
    }
}
