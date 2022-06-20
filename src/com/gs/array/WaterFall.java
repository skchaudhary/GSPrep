package com.gs.array;

import java.util.Arrays;

public class WaterFall {
    public static void main(String[] args) {
        double[][] array = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        int source = 8;
        Arrays.stream(new WaterFall().waterfallStreams(array, source)).forEach(i-> System.out.print(i+" "));
    }

    public double[] waterfallStreams(double[][] array, int source) {
        // Write your code here.
        boolean[][] visited = new boolean[array.length][array[0].length];
        flowWater(array, 0, source, 100.0, visited);
        return array[array.length-1];
    }

    private void flowWater(double[][] array, int i, int j, double percentage, boolean[][] visited) {
        if (i==array.length-1) {
            array[i][j]+=percentage;
            return;
        }

        if (j<0 || j>=array[0].length || array[i][j]==1 || visited[i][j]) {
            return;
        }

        visited[i][j]=true;
        if (array[i+1][j]==0 || i+1==array.length-1) {
            flowWater(array, i+1, j, percentage, visited);
        } else {
            if (j-1>=0 && j+1<array[0].length && !visited[i][j-1] && !visited[i][j+1]) {
                flowWater(array, i, j-1, percentage/2, visited);
                flowWater(array, i, j+1, percentage/2, visited);
            } else if (j-1>=0 && !visited[i][j-1]) {
                flowWater(array, i, j-1, percentage, visited);
            } else {
                flowWater(array, i, j+1, percentage, visited);
            }
        }
        visited[i][j]=false;
    }

}
