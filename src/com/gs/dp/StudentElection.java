package com.gs.dp;

import com.gs.util.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StudentElection {
    public static void main(String[] args) {
        System.out.println(whoIsElected(1, 1));
        System.out.println(whoIsElected(2, 2));
        System.out.println(whoIsElected(4, 2));
    }

    private static int whoIsElected(int n, int k) {
        List<Integer> list = new LinkedList<>();
        for (int i=1;i<=n;i++) {
            list.add(i);
        }
        int c=n;
        int pos=k-1;
        while (c!=1) {
            pos = pos%c;
            list.remove(pos);
            pos+=k;
        }

        return list.get(0);
    }

}
