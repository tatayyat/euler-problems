package com.tatayyat.euler.problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/***
 * Find out the largest prime factor of the given number 600851475143L
 */
public class PrimeFactor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter the number to find largest prime factor");
        var largestPrimeFactorOf = scanner.nextLong();
        //Solution for 600851475143
        printLargestPrimeFactor(largestPrimeFactorOf);
    }

    static void printLargestPrimeFactor(long factNum) {
        List<Integer> factors = new ArrayList<>();
        for (var i = 2; i < Math.sqrt(factNum); i++) {
            if (factNum % i == 0) {
                factors.add(i);
            }
        }
        LOGGER.info("Factors of : {} is {} ", factNum, factors);
        List<Integer> primeFactors = factors.stream().filter(p -> BigInteger.valueOf(p).isProbablePrime(100)).collect(Collectors.toList());

        LOGGER.info("Prime Factors of : {} is {} ", factNum, primeFactors);
        LOGGER.info("Largest Prime Factor of the number: {} is {}", factNum, Collections.max(primeFactors));
    }
}
