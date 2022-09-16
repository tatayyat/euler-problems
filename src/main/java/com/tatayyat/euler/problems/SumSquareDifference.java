package com.tatayyat.euler.problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 6 : Sum square difference
 */
public class SumSquareDifference {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter the max natural number to perform sum square difference : ");
        int maxNumber = scanner.nextInt();
        findSumSquareDifference(maxNumber);
    }

    private static void findSumSquareDifference(int firstNNumbers) {
        List<Integer> squares = new ArrayList<>();
        int sumOfNumbers = 0;

        for (var naturalNumber = 1; naturalNumber <= firstNNumbers; naturalNumber++) {
            squares.add(naturalNumber * naturalNumber);
            sumOfNumbers = sumOfNumbers + naturalNumber;
        }
        int sumOfSquares = squares.stream().mapToInt(Integer::intValue).sum();
        int squareOfSum = sumOfNumbers * sumOfNumbers;

        LOGGER.info("Sum of squares: {}", sumOfSquares);
        LOGGER.info("Square of Sums : {}", squareOfSum);
        LOGGER.info("Sum of the squares and square of the sum difference for the first {} is {}", firstNNumbers, (squareOfSum - sumOfSquares));
    }
}
