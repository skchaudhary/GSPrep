package com.gs.mathematics;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public static void main(String[] args) {
        System.out.println(primeFactorization(10).toString());
        System.out.println(primeFactorization(90).toString());
        System.out.println(primeFactorization(100).toString());
        System.out.println(primeFactorization(16).toString());
        System.out.println(primeFactorization(0).toString());
    }

    public static List<Integer> primeFactorization(int x) {
        List<Integer> ans = new ArrayList<>();
        if (x == 0) {
            return ans;
        }
        if (x%2==0) {
            while (x%2==0) {
                ans.add(2);
                x/=2;
            }
        }

        for (int i=3;i<=x;i+=2) {
            while (x%i==0) {
                ans.add(i);
                x/=i;
            }
        }
        return ans;
    }
}
