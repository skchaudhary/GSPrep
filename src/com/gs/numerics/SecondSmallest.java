package com.gs.numerics;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SecondSmallest {
    public static void main(String[] args) {
        System.out.println(secondSmallest(new int[]{-1, 0, 1, -2, 2}));
        System.out.println(secondSmallest(new int[]{0, 1, -1}));
    }

    private static int secondSmallest(int[] x) {
        if (x==null || x.length<2) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int a: x) {
            pq.offer(a);
            if (pq.size()<=2) {
                continue;
            }
            pq.poll();
        }

        return pq.poll();
    }
}
