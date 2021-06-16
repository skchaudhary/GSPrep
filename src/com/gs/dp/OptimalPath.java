package com.gs.dp;

import java.util.LinkedList;
import java.util.Queue;

public class OptimalPath {
    public static void main(String[] args) {
        System.out.println(optimalPath(new int[][]{{0,0,0,0,5},{0,1,1,1,0},{2,0,0,0,0}}));
    }

    private static Integer optimalPath(int[][] grid) {
        int start_x=grid.length-1;
        int start_y=0;

        int end_x=0;
        int end_y=grid[0].length-1;
        int[][] dp = new int[grid.length][grid[0].length];

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{start_x, start_y});
        dp[start_x][start_y] = grid[start_x][start_y];

        while (!q.isEmpty()) {
            int[] point = q.poll();

            // check if able to move up and is valid path then consider it
            if (point[0]-1 >= 0 && dp[point[0]][point[1]] + grid[point[0]-1][point[1]] >= dp[point[0]-1][point[1]]) {
                dp[point[0]-1][point[1]] = dp[point[0]][point[1]] + grid[point[0]-1][point[1]];
                q.add(new int[] {point[0]-1, point[1]});
            }

            // check if able to move right and is valid path then consider it
            if (point[1] + 1 < grid[0].length && dp[point[0]][point[1]] + grid[point[0]][point[1]+1] >= dp[point[0]][point[1]+1]) {
                dp[point[0]][point[1]+1] = dp[point[0]][point[1]] + grid[point[0]][point[1]+1];
                q.add(new int[] {point[0], point[1]+1});
            }
        }

        return dp[end_x][end_y];
    }
}
