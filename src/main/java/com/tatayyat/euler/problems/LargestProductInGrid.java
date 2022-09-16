package com.tatayyat.euler.problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
 * What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
 */
public class LargestProductInGrid {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        int[][] productGrid2020 = new int[20][20];

        String strFor2020Grid =
                "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08" +
                        " 49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00" +
                        " 81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65" +
                        " 52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91" +
                        " 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80" +
                        " 24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50" +
                        " 32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70" +
                        " 67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21" +
                        " 24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72" +
                        " 21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95" +
                        " 78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92" +
                        " 16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57" +
                        " 86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58" +
                        " 19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40" +
                        " 04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66" +
                        " 88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69" +
                        " 04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36" +
                        " 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16" +
                        " 20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54" +
                        " 01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";

        List<String> stringList = Arrays.asList(strFor2020Grid.split(" "));

        int row = 0;
        for (int i = 0; i < 400; i = i + 20) {
            for (int j = 0; j < 20; j++) {
                var indexToLook = i + j;
                if (stringList.get(indexToLook) != null) {
                    productGrid2020[row][j] = Integer.parseInt(stringList.get(indexToLook));
                }
            }
            row++;
        }

        List<NumbersGroup> numbersGroups = findNumberGroupsInAllDirections(productGrid2020);

        long largestProduct = 0L;
        for (NumbersGroup numbersGroup : numbersGroups) {
            var currentProduct =
                    Long.valueOf((long) numbersGroup.getFirstNum() * numbersGroup.getSecondNum() * numbersGroup.getThirdNum() * numbersGroup.getFourthNum());
            if (currentProduct > largestProduct) {
                largestProduct = currentProduct;
            }
        }
        LOGGER.info("largestProduct : {}", largestProduct);
    }

    private static List<NumbersGroup> findNumberGroupsInAllDirections(int[][] productGrid2020) {
        List<NumbersGroup> numbersGroups = new ArrayList<>();

        for (int rowNum = 0; rowNum < productGrid2020[0].length; rowNum++) {
            for (int columnNum = 0; columnNum < productGrid2020.length; columnNum++) {
                numbersGroups.addAll(generateNumbersGroup(rowNum, columnNum, productGrid2020));
            }
        }
        return numbersGroups;
    }

    private static List<NumbersGroup> findDiagonalGroups(int rowNum, int columnNum, int[][] grid) {
        List<NumbersGroup> numbersGroups = new ArrayList<>();
        if (rowNum >= 3 && columnNum <= 16) {
            //upward right
            var firstNum = grid[rowNum][columnNum];
            var secondNum = grid[rowNum - 1][columnNum + 1];
            var thirdNum = grid[rowNum - 2][columnNum + 2];
            var fourthNum = grid[rowNum - 3][columnNum + 3];

            numbersGroups.add(new NumbersGroup(firstNum, secondNum, thirdNum, fourthNum));
        }
        if (rowNum >= 3 && columnNum >= 3) {
            //upward left
            var firstNum = grid[rowNum][columnNum];
            var secondNum = grid[rowNum - 1][columnNum - 1];
            var thirdNum = grid[rowNum - 2][columnNum - 2];
            var fourthNum = grid[rowNum - 3][columnNum - 3];

            numbersGroups.add(new NumbersGroup(firstNum, secondNum, thirdNum, fourthNum));
        }
        if (rowNum <= 16 && columnNum <= 16) {
            //diagonal downward right
            var firstNum = grid[rowNum][columnNum];
            var secondNum = grid[rowNum + 1][columnNum + 1];
            var thirdNum = grid[rowNum + 2][columnNum + 2];
            var fourthNum = grid[rowNum + 3][columnNum + 3];

            numbersGroups.add(new NumbersGroup(firstNum, secondNum, thirdNum, fourthNum));
        }
        if (rowNum <= 16 && columnNum >= 3) {
            //diagonal downward left
            var firstNum = grid[rowNum][columnNum];
            var secondNum = grid[rowNum + 1][columnNum - 1];
            var thirdNum = grid[rowNum + 2][columnNum - 2];
            var fourthNum = grid[rowNum + 3][columnNum - 3];

            numbersGroups.add(new NumbersGroup(firstNum, secondNum, thirdNum, fourthNum));
        }
        return numbersGroups;
    }

    private static NumbersGroup findRightGroup(int rowNum, int columnNum, int[][] grid) {
        if (columnNum <= 16) {
            var firstNum = grid[rowNum][columnNum];
            var secondNum = grid[rowNum][columnNum + 1];
            var thirdNum = grid[rowNum][columnNum + 2];
            var fourthNum = grid[rowNum][columnNum + 3];

            return new NumbersGroup(firstNum, secondNum, thirdNum, fourthNum);
        }
        return null;
    }

    private static NumbersGroup findLeftGroup(int rowNum, int columnNum, int[][] grid) {
        if (columnNum >= 3) {
            var firstNum = grid[rowNum][columnNum];
            var secondNum = grid[rowNum][columnNum - 1];
            var thirdNum = grid[rowNum][columnNum - 2];
            var fourthNum = grid[rowNum][columnNum - 3];
            return new NumbersGroup(firstNum, secondNum, thirdNum, fourthNum);
        }
        return null;
    }

    private static NumbersGroup findDownwardsGroup(int rowNum, int columnNum, int[][] grid) {
        if (rowNum <= 16) {
            var firstNum = grid[rowNum][columnNum];
            var secondNum = grid[rowNum + 1][columnNum];
            var thirdNum = grid[rowNum + 2][columnNum];
            var fourthNum = grid[rowNum + 3][columnNum];

            return new NumbersGroup(firstNum, secondNum, thirdNum, fourthNum);
        }
        return null;
    }

    private static NumbersGroup findUpwardsGroup(int rowNum, int columnNum, int[][] grid) {
        if (rowNum >= 3) {
            var firstNum = grid[rowNum][columnNum];
            var secondNum = grid[rowNum - 1][columnNum];
            var thirdNum = grid[rowNum - 2][columnNum];
            var fourthNum = grid[rowNum - 3][columnNum];

            return new NumbersGroup(firstNum, secondNum, thirdNum, fourthNum);
        }
        return null;
    }

    static List<NumbersGroup> generateNumbersGroup(int rowNum, int columnNum, int[][] productGrid2020) {
        List<NumbersGroup> numbersGroups = new ArrayList<>();
        NumbersGroup upwardGroup = findUpwardsGroup(rowNum, columnNum, productGrid2020);
        if (upwardGroup != null) {
            numbersGroups.add(upwardGroup);
        }
        NumbersGroup downwardGroup = findDownwardsGroup(rowNum, columnNum, productGrid2020);
        if (downwardGroup != null) {
            numbersGroups.add(downwardGroup);
        }
        NumbersGroup leftGroup = findLeftGroup(rowNum, columnNum, productGrid2020);
        if (leftGroup != null) {
            numbersGroups.add(leftGroup);
        }
        NumbersGroup rightGroup = findRightGroup(rowNum, columnNum, productGrid2020);
        if (rightGroup != null) {
            numbersGroups.add(rightGroup);
        }
        List<NumbersGroup> diagonalGroup = findDiagonalGroups(rowNum, columnNum, productGrid2020);
        if (!diagonalGroup.isEmpty()) {
            numbersGroups.addAll(diagonalGroup);
        }
        return numbersGroups;
    }
}

class NumbersGroup {
    private final int firstNum;
    private final int secondNum;
    private final int thirdNum;
    private final int fourthNum;

    public NumbersGroup(int firstNum, int secondNum, int thirdNum, int fourthNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.thirdNum = thirdNum;
        this.fourthNum = fourthNum;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public int getThirdNum() {
        return thirdNum;
    }

    public int getFourthNum() {
        return fourthNum;
    }

    @Override
    public String toString() {
        return "com.tatayyat.euler.problems.NumbersGroup{" + "firstNum=" + firstNum + ", secondNum=" + secondNum +
                ", thirdNum=" + thirdNum + ", fourthNum=" + fourthNum + '}';
    }
}
