package com.gs.array;

import java.util.Arrays;

public class FindProductExceptItself {
    public static void main(String[] args) {
//        int[] result = new FindProductExceptItself().findTheProductArray(new int[]{1, 2, 3});

//        Arrays.stream(result).forEach(element -> System.out.print(element +" "));
    }

    enum RecipientType {
        VALUE_ONE,
        VALUE_TWO
    }
    private int[] findTheProductArray(int[] input) {

        if (input.length==1) {
            return input;
        }

        int[] productFromStart = new int[input.length];
        int[] productFromEnd = new int[input.length];

        int product = 1;
        for (int i=0;i<input.length;i++) {
            product*=input[i];
            productFromStart[i]= product;
        }
        product=1;
        for (int i=input.length-1;i>=0;i--) {
            product*=input[i];
            productFromEnd[i]=product;
        }

        int[] result = new int[input.length];
        for (int i=0;i<input.length;i++) {
            if (i==0) {
                result[i]= productFromEnd[i+1];
            } else if (i==input.length-1) {
                result[i]= productFromStart[i-1];
            } else {
                result[i]= productFromStart[i-1] * productFromEnd[i+1];
            }
        }

        return result;
    }
}
/**
 * input = 1,2,3
 * product =1, start[] = 1, 2, 6
 * product=1, end[] = 6,6,3
 *
 */

