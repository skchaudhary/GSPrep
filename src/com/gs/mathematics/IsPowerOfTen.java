package com.gs.mathematics;

public class IsPowerOfTen {
    public static void main(String[] args) {
        System.out.println(isPowerOf10(10));
        System.out.println(isPowerOf10(3));
    }
    private static boolean isPowerOf10(int x){
        while (x>1) {
            if (x%10 != 0){
                return false;
            }
            x = x/10;
        }
        return x==1;
    }

}
