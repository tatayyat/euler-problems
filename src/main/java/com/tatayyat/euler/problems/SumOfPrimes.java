package com.tatayyat.euler.problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.math.BigInteger;
import java.util.Scanner;

/***
 Summation of primes
 The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 Find the sum of all the primes below two million.
 */
public class SumOfPrimes {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        LOGGER.info("Enter Prime Numbers with in to find ");
        Scanner scanner = new Scanner(System.in);
        Long primeNumberWithIn = scanner.nextLong();
        printSumOfPrimesWithIn(primeNumberWithIn);
        Long endTime = System.currentTimeMillis();
        LOGGER.info("Time taken in milli {}", (endTime - startTime));
    }

    static void printSumOfPrimesWithIn(Long primeNumberWithIn) {
        var sumOfPrimes = 0L;
        for (var i = 2; i <= primeNumberWithIn; i++) {
            if (BigInteger.valueOf(i).isProbablePrime(100)) {
                sumOfPrimes += i;
            }
        }
        LOGGER.info("Sum of prime numbers with in  : {} is {}", primeNumberWithIn, sumOfPrimes);
    }
}
