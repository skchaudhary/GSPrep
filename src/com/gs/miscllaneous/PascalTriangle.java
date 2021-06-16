package com.gs.miscllaneous;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(pascal(0, 0));
        System.out.println(pascal(1, 2));
        System.out.println(pascal(4, 8));
    }

    public static int pascal(int col, int row){
        if (col>row) {
            return -1;
        }

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(1);
        results.add(result);

        for (int i=1;i<=row;i++) {
            result = new ArrayList<>();
            result.add(1);
            for (int j=1;j<i;j++) {
                List<Integer> prev = results.get(i-1);
                result.add(prev.get(j) + prev.get(j-1));
            }
            result.add(1);
            results.add(result);
        }

        return results.get(row).get(col);
    }
}
