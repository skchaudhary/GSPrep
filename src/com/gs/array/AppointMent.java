package com.gs.array;

import java.util.Arrays;

public class AppointMent {
    public static void main(String[] args) {
        int[][] appointTimes = {{1,4}, {2,5}, {7,9}};
        System.out.println(isAbleToAttendTheMeetings(appointTimes));

        appointTimes = new int[][]{{6,7}, {2,4}, {8,12}};
        System.out.println(isAbleToAttendTheMeetings(appointTimes));
    }

    private static boolean isAbleToAttendTheMeetings(int[][] appointTimes) {
        Arrays.sort(appointTimes, (a1, a2) -> {
            if (a1[0]==a2[0]) {
                return Integer.compare(a1[1], a2[1]);
            } else {
                return Integer.compare(a1[0], a2[0]);
            }
        });

        int start = appointTimes[0][0];
        int end = appointTimes[0][1];

        int overlap = 0;
        for (int[] appointmentTime : appointTimes) {
            if (appointmentTime[0]<end) {
                overlap++;
                start = Math.max(start, appointmentTime[0]);
                end = Math.min(end, appointmentTime[1]);
            } else {
                overlap=1;
                start = Math.max(start, appointmentTime[0]);
                end = Math.max(end, appointmentTime[1]);
            }

            if (overlap>1) {
                return false;
            }
        }
        return true;
    }
}
