package com.gs.dp;

public class WalkingRobot {
    public static void main(String[] args) {
        Integer[] ans = walk("");
        System.out.println("[" + ans[0] + " " + ans[1] + "]");
        ans = walk("L");
        System.out.println("[" + ans[0] + " " + ans[1] + "]");
        ans = walk("UUU");
        System.out.println("[" + ans[0] + " " + ans[1] + "]");
        ans = walk("ULDR");
        System.out.println("[" + ans[0] + " " + ans[1] + "]");
    }

    private static Integer[] walk(String path) {
        Integer[] xy=new Integer[2];
        xy[0]=0;
        xy[1]=0;
        for (char c : path.toCharArray()) {
            if (c=='L') {
                xy[0]-=1;
            } else if (c=='R') {
                xy[0]+=1;
            } else if (c=='U') {
                xy[1]+=1;
            } else if (c=='D') {
                xy[1]-=1;
            }
        }
        return xy;
    }
}
