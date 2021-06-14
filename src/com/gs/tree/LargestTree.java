package com.gs.tree;

import java.util.*;

public class LargestTree {
    public static void main(String[] args) {
        Map<Integer, Integer> immediateParent = new HashMap<>();
        immediateParent.put(1, 2);
        immediateParent.put(3, 4);
        System.out.println(largestTree(immediateParent));
    }

    private static Integer largestTree(final Map<Integer, Integer> immediateParent) {
        if (immediateParent==null || immediateParent.size()==0) {
            return 0;
        }

        Map<Integer, Set<Integer>> result = new HashMap<>();
        for (Map.Entry<Integer, Integer> en : immediateParent.entrySet()) {
            if (!immediateParent.containsKey(en.getValue())) {
                result.put(en.getValue(), new HashSet<>());
            }
        }

        for (Map.Entry<Integer, Integer> en : immediateParent.entrySet()) {
            int child = en.getKey();
            Set<Integer> nodes = new HashSet<>();
            while (immediateParent.containsKey(child)) {
                nodes.add(child);
                child = immediateParent.get(child);
            }

            nodes.add(child);
            result.get(child).addAll(nodes);
        }

        int size = 0;
        int id = -1;
        for (Map.Entry<Integer, Set<Integer>> en : result.entrySet()) {
            if (en.getValue().size()>size) {
                size = en.getValue().size();
                id = en.getKey();
            } else if (en.getValue().size()==size) {
                id = Math.min(en.getKey(), id);
            }
        }
        return id;
    }
}
