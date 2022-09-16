package com.tatayyat.euler.problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 **/
public class PythagoreanTriplet {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Finding magic triplet with in ");
        int maxNum = scanner.nextInt();
        LOGGER.info("Sum of magic triplet should be");
        int magicSum = scanner.nextInt();
        boolean magicTriplet = false;

        for (int firstNum = 1; firstNum <= maxNum; firstNum++) {
            if (magicTriplet) {
                break;
            }
            for (int secondNum = firstNum + 1; secondNum <= maxNum; secondNum++) {
                for (int thirdNum = secondNum + 1; thirdNum <= maxNum; thirdNum++) {
                    magicTriplet = isMagicTriple(firstNum, secondNum, thirdNum, magicSum);
                    if (magicTriplet) {
                        break;
                    }
                }
            }
        }
    }

    static boolean isMagicTriple(int firstNum, int secondNum, int thirdNum, int magicSum) {
        if (firstNum + secondNum + thirdNum == magicSum) {
            var firstTripletNum = firstNum * firstNum;
            var secondTripletNum = secondNum * secondNum;
            var thirdTripletNum = thirdNum * thirdNum;

            var isTriplet = firstTripletNum + secondTripletNum == thirdTripletNum
                    || secondTripletNum + thirdTripletNum == firstTripletNum
                    || firstTripletNum + thirdTripletNum == secondTripletNum;

            if (isTriplet) {
                LOGGER.info("Magic Triplet : {}, {}, {} ", firstNum, secondNum, thirdNum);
                LOGGER.info("ABC of Magic Triple: {}", firstNum * secondNum * thirdNum);
                return true;
            }
        }
        return false;
    }
}
