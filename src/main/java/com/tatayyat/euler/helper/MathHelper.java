package com.tatayyat.euler.helper;

import java.util.HashSet;
import java.util.Set;

public class MathHelper {

    private MathHelper() {
        //private
    }

    public static Set<Integer> factorsOf(int factNum) {
        Set<Integer> factors = new HashSet<>();
        for (var i = 1; i <= factNum; i++) {
            if (factNum % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }
}
