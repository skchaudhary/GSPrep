package com.gs.mathematics;

public class AddFraction {
    public static void main(String[] args) {
        int[] res = addFractions(new int[]{2, 3}, new int[]{1, 2});
        System.out.println(res[0] == 7 && res[1] == 6);

        res = addFractions(new int[]{15, 30}, new int[]{55, 18});
        System.out.println(res[0] == 32 && res[1] == 9);
    }

    private static int[] addFractions ( int[] fraction1, int[] fraction2 ){
        int hcf = gcd(fraction1[1], fraction2[1]);

        int deno = (fraction1[1] * fraction2[1])/hcf;
        int numr = (fraction1[0] * fraction2[1])/hcf + (fraction2[0] * fraction1[1])/hcf;

        int cf = gcd(numr, deno);
        numr = numr/cf;
        deno = deno/cf;

        return new int[]{numr, deno};
    }

    private static int gcd(int i, int j) {
        int rem = j % i;
        while (rem != 0) {
            j = i;
            i = rem;
            rem = j % i;
        }
        return i;
    }

}
