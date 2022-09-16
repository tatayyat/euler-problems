package com.tatayyat.euler.problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/***
 * Prints the multiple of 3 or 5 below 1000.
 * Java program
 */
public class MultiplesOf {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        printMultiplesOf();
    }

    static void printMultiplesOf() {
        int sumOfMultiples = 0;
        for (var i = 0; i < 1000; i++) {
            if (isMultipleOf(i, 3) || isMultipleOf(i, 5)) {
                sumOfMultiples = sumOfMultiples + i;
            }
        }
        LOGGER.info("the sum of all the multiples of 3 or 5 below 1000 is {}", sumOfMultiples);
    }

    static boolean isMultipleOf(Integer numberToCheck, Integer multipleToCheck) {
        if (multipleToCheck == 0) {
            return false;
        }
        return numberToCheck % multipleToCheck == 0;
    }
}