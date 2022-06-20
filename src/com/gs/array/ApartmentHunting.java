package com.gs.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentHunting {
    public static void main(String[] args) {
        List<Map<String, Boolean>> blocks = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();
        map.put("gym", false);
        map.put("school", true);
        map.put("store", false);
        blocks.add(map);

        map = new HashMap<>();
        map.put("gym", true);
        map.put("school", false);
        map.put("store", false);
        blocks.add(map);

        map = new HashMap<>();
        map.put("gym", true);
        map.put("school", true);
        map.put("store", false);
        blocks.add(map);

        map = new HashMap<>();
        map.put("gym", false);
        map.put("school", true);
        map.put("store", false);
        blocks.add(map);

        map = new HashMap<>();
        map.put("gym", false);
        map.put("school", true);
        map.put("store", true);
        blocks.add(map);

        String[] reqs={"gym", "school", "store"};

        System.out.println(apartmentHunting(blocks, reqs));
    }

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.
        int ans = Integer.MAX_VALUE;
        int index=0;
        for (int i=0;i<blocks.size();i++) {
            int[] minDist = new int[reqs.length];
            boolean[] isFilled = new boolean[reqs.length];

            Map<String, Boolean> presentBlock = blocks.get(i);
            boolean isAllFilled = true;
            for (int j=0;j<reqs.length;j++) {
                isFilled[j]=presentBlock.get(reqs[j]);
                if (!isFilled[j]) {
                    isAllFilled=false;
                }
            }

            if(isAllFilled) {
                return i;
            } else {
                int left = i-1;
                int right = i+1;
                while (left>=0 || right<blocks.size()) {
                    isAllFilled=left>=0?true:false;
                    if (left>=0) {
                        presentBlock = blocks.get(left);
                        for (int j=0;j<reqs.length;j++) {
                            if (!isFilled[j]) {
                                isFilled[j]=presentBlock.get(reqs[j]);
                                minDist[j]+=1;
                            }

                            if (!isFilled[j]) {
                                isAllFilled=false;
                            }
                        }
                    }

                    if(isAllFilled) {
                        break;
                    }
                    isAllFilled = right<blocks.size() ? true:false;
                    if (right<blocks.size()) {
                        presentBlock = blocks.get(right);
                        for (int j=0;j<reqs.length;j++) {
                            if (!isFilled[j]) {
                                isFilled[j]=presentBlock.get(reqs[j]);
                                if (left<0) {
                                    minDist[j]+=1;
                                }
                            }
                            if (!isFilled[j]) {
                                isAllFilled=false;
                            }
                        }
                    }

                    if(isAllFilled) {
                        break;
                    }
                    left--;right++;
                }
            }

            int sum = max(minDist);
            if (ans>sum) {
                ans=sum;
                index=i;
            }
        }
        return index;
    }

    private static int max(int[] dist) {
        int max=0;
        for (int a:dist) {
            max=Math.max(max, a);
        }

        return max;
    }
}
