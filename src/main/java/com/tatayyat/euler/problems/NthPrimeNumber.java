package com.tatayyat.euler.problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NthPrimeNumber {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("What is the nth prime number? n = ");
        int nthPrimeNumber = scanner.nextInt();
        printNthPrimeNumber(nthPrimeNumber);
        printNthPrimeNumberWhile(nthPrimeNumber);
    }

    static void printNthPrimeNumber(int nthPrimeNumber) {
        List<Integer> primeNumbers = new ArrayList<>();
        int noOfPrimes = 1;
        for (int i = 1; i < 1000000; i++) {
            if (BigInteger.valueOf(i).isProbablePrime(100)) {
                primeNumbers.add(i);
                noOfPrimes++;
            }
            if (noOfPrimes > nthPrimeNumber) {
                break;
            }
        }
        LOGGER.info("All Prime Numbers : {} " , primeNumbers);
        if (primeNumbers.size() >= nthPrimeNumber) {
            LOGGER.info("Nth Prime Number : {}" , primeNumbers.get(nthPrimeNumber - 1));
        }
    }


    static void printNthPrimeNumberWhile(int nthPrimeNumber) {
        List<Integer> primeNumbers = new ArrayList<>();
        int noOfPrimes = 1;
        int numberCnt = 1;
        while (nthPrimeNumber >= noOfPrimes) {
            if (BigInteger.valueOf(numberCnt).isProbablePrime(100)) {
                primeNumbers.add(numberCnt);
                noOfPrimes++;
            }
            numberCnt++;
        }
        LOGGER.info("All Prime Numbers : {}" , primeNumbers);
        if (primeNumbers.size() >= nthPrimeNumber) {
            LOGGER.info("Nth Prime Number : {}" , primeNumbers.get(nthPrimeNumber - 1));
        }
    }
}
