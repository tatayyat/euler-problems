package com.tatayyat.euler.problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;

/***
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class SmallestMultiple {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter the number to find smallest multiple");
        var smallestMultipleOf = scanner.nextInt();
        printSmallestMultiple(smallestMultipleOf);
    }

    static void printSmallestMultiple(int numbersToMultiple) {
        int multipleNumber = 1;
        int finalMultipleNumber = 0;
        boolean validMultiple = false;
        while (!validMultiple) {
            multipleNumber++;
            for (var i = 1; i <= numbersToMultiple; i++) {
                if (multipleNumber % i == 0) {
                    validMultiple = true;
                } else {
                    validMultiple = false;
                    break;
                }
                if (i == numbersToMultiple) {
                    finalMultipleNumber = multipleNumber;
                }
            }
        }
        LOGGER.info("Final multiple number : {}", finalMultipleNumber);
    }
}
