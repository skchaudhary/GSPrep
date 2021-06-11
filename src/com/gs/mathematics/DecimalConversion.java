package com.gs.mathematics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DecimalConversion {
    public static void main(String[] args) {
        System.out.println(vulgarToDecimal(1l, 2l).equals("0.5"));
        System.out.println(vulgarToDecimal(1l, 3l).equals("0.(3)"));
        System.out.println(vulgarToDecimal(1l, 30l).equals("0.0(3)"));
        System.out.println(vulgarToDecimal(1l, 75l).equals("0.01(3)"));
        System.out.println(vulgarToDecimal(4l, 7l).equals("0.(571428)"));

    }

    public static String vulgarToDecimal(Long numerator, Long denominator) {
        if (numerator == 0) {
            return "0.0";
        }
        StringBuffer res = new StringBuffer();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");

        // Integral part
        res.append(numerator/denominator);
        numerator = numerator%denominator;
        if (numerator==0) {
            return res.toString() + ".0";
        }

        // fractional part
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(numerator, res.length());
        while (numerator!=0) {
            numerator=numerator*10;
            res.append(numerator/denominator);
            numerator = numerator%denominator;
            if (map.containsKey(numerator)) {
                int index = map.get(numerator);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(numerator, res.length());
            }
        }

        return res.toString();
    }

}
