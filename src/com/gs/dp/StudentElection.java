package com.gs.dp;

public class StudentElection {
    public static void main(String[] args) {
        System.out.println(whoIsElected(1, 1));
        System.out.println(whoIsElected(2, 1));
        System.out.println(whoIsElected(4, 2));
        System.out.println(whoIsElected(5, 2));
    }

    private static int whoIsElected(int n, int k) {
        int[] dp =new int[n];
        dp[0]=0;

        for (int i=1;i<n;i++) {
            dp[i]=(dp[i-1]+k)%(i+1);
        }

        return dp[n-1]+1;
    }

}
