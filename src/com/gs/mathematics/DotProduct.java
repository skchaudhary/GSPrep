package com.gs.mathematics;

public class DotProduct {
    public static void main(String[] args) {
        long ans = dotProduct(new int[]{1, 2}, new int[]{2, 3});
        System.out.println(ans == 8);
    }
    private static long dotProduct( int[] array1, int array2[] ){
        if (array1.length != array2.length) {
            return -1;
        }

        long ans = 0;
        for (int i=0;i<array1.length;i++) {
            ans += array1[i]*array2[i];
        }

        return ans;
    }
}
