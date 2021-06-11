package com.gs.mathematics;

public class PowerOfExpo {
    public static void main(String[] args) {
        double ans = power(2, 2);
        System.out.println(ans);
        System.out.println(ans == 4.0);

        ans = power(7, 3);
        System.out.println(ans);
        System.out.println(ans == 343.0);

        ans = power(2, 7);
        System.out.println(ans);
        System.out.println(ans == 128.0);
    }
    public static double power(double base, int exp) {
        if (exp == 0) return 1;

        if (exp<0) {
            exp = -exp;
            base = 1/base;
        }

        double ans = 1.0;
        while (exp>0) {
            if ((exp&1) == 1) {
                ans *=base;
            }
            base *= base;
            exp = exp>>1;
        }

        return ans;
    }

}
