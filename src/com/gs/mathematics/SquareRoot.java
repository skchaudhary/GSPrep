package com.gs.mathematics;

public class SquareRoot {
    public static void main(String[] args) {
        double ans = squareRoot(4);
        System.out.println(ans == 2.0);

        ans = squareRoot(2);
        System.out.println(ans);
        System.out.println(ans == 1.41421);
    }

    private static double squareRoot(double x ){

        int i = 1;
        while(true){
            if(i*i==x){
                return i;
            }else if(i*i>x){
                return getSqrt(x, i-1, i);
            }else{
               i++;
            }
        }
    }

    private static double getSqrt(double x, double i, double j) {
        double mid = (i+j)/2;

        double square = mid * mid;
        if (square == x || Math.abs(square - x)<0.0000001) {
            return mid;
        } else if (square>x) {
            return getSqrt(x, i, mid);
        } else {
            return getSqrt(x, mid, j);
        }
    }

}
