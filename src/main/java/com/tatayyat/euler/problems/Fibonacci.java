package com.tatayyat.euler.problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

/***
 * Prints the sum of Even com.tatayyat.euler.problems.Fibonacci numbers (last value in the series must be < 4 million).
 * Java program
 */
public class Fibonacci {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        findFibonacci();
    }

    static void findFibonacci() {
        List<Integer> fibSeries = new ArrayList<>();
        int fib1 = 1;
        int fib2 = 2;
        fibSeries.add(1);
        fibSeries.add(2);

        while (fib2 < 4000000) {
            Integer fibNew = fibonacciOf(fib1, fib2);
            fibSeries.add(fibNew);
            fib1 = fib2;
            fib2 = fibNew;
        }
        LOGGER.info("Fib series {}" , fibSeries);
        int evenValCount = fibSeries.stream().filter(p -> p % 2 == 0).mapToInt(Integer::intValue).sum();

        LOGGER.info("Even val count {}" , evenValCount);
    }

    static Integer fibonacciOf(Integer fib1, Integer fib2) {
        return fib1 + fib2;
    }
}