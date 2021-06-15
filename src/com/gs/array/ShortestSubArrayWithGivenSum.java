package com.gs.array;

public class ShortestSubArrayWithGivenSum {
    public static void main(String[] args) {
        System.out.println(subArrayExceedsSum(new int[]{1,2,3,4}, 6));
        System.out.println(subArrayExceedsSum(new int[]{1,2,3,4}, 12));
    }
    private static int subArrayExceedsSum(int arr[], int target) {
        int sum=0, window=Integer.MAX_VALUE;
        int i=0,j=0;

        while (j<arr.length) {
            if (sum<target) {
                sum+=arr[j];
                j++;
            } else {
                if (window>(j-i)){
                    window = j-i;
                }
                sum-=arr[i];
                i++;
            }
        }

        while (sum>=target && i<arr.length) {
            if (window>(j-i)){
                window = j-i;
            }
            sum-=arr[i];
            i++;
        }

        return (window==Integer.MAX_VALUE?-1:window);
    }

}
