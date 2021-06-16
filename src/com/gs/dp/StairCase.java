package com.gs.dp;

public class StairCase {
    public static void main(String[] args) {
        System.out.println(countSteps(3));
        System.out.println(countSteps(1));
        System.out.println(countSteps(2));
        System.out.println(countSteps(10));
        System.out.println(countSteps(-5));
    }

    private static Integer countSteps(Integer n) {
        if (n<0) {
            return 0;
        }
        if (n<=2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0]=1;
        dp[1]=2;
        dp[2]=4;
        if (n==3) {
            return dp[n-1];
        }

        for (int i=3;i<n;i++) {
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }

        return dp[n-1];
    }
}
