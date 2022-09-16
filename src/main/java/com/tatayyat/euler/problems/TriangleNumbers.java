package com.tatayyat.euler.problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TriangleNumbers {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Minimum no.of divisors to check");
        var minNoOfDivisors = scanner.nextInt();

        int incrementer = 0;
        int currentNum = 0;
        while (incrementer >= 0) {
            incrementer++;
            currentNum = currentNum + incrementer;
            int noOfDivisors = findNoOfDivisors(currentNum);
            if (noOfDivisors >= minNoOfDivisors) {
                LOGGER.info("Triangle number to have more than {} divisors is {}", minNoOfDivisors - 1, currentNum);
                break;
            }
        }
    }

    static int findNoOfDivisors(int factNum) {
        //can be improved
        return (int) IntStream.rangeClosed(1, factNum).filter(p -> factNum % p == 0).count();
    }
}
