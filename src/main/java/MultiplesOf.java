/***
 * Prints the multiple of 3 or 5 below 1000.
 * Java program
 */
public class MultiplesOf {

    public static void main(String[] args) {
        printMultiplesOf();
    }

    static void printMultiplesOf() {
        int sumOfMultiples = 0;
        for (var i = 0; i < 1000; i++) {
            if (isMultipleOf(i, 3) || isMultipleOf(i, 5)) {
                sumOfMultiples = sumOfMultiples + i;
            }
        }
        System.out.println("the sum of all the multiples of 3 or 5 below 1000 is " + sumOfMultiples);
    }

    static boolean isMultipleOf(Integer numberToCheck, Integer multipleToCheck) {
        if (multipleToCheck == 0) {
            return false;
        }
        return numberToCheck % multipleToCheck == 0;
    }
}