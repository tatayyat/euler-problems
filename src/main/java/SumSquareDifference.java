import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 6 : Sum square difference
 */
public class SumSquareDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the max natural number to perform sum square difference : ");
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

        System.out.println("Sum of squares: " + sumOfSquares);
        System.out.println("Square of Sums : " + squareOfSum);
        System.out.println("Sum of the squares and square of the sum difference for the first " + firstNNumbers + " is : " + (squareOfSum - sumOfSquares));
    }
}
