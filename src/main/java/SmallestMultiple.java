/***
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class SmallestMultiple {
    public static void main(String[] args) {
        printSmallestMultiple(20);
    }

    static void printSmallestMultiple(int numbersToMultiple) {
        int multipleNumber = 1;
        int finalMultipleNumber = 0;
        boolean validMultiple = false;
        while (!validMultiple) {
            multipleNumber++;
            for (var i = 1; i <= numbersToMultiple ; i++) {
                if (multipleNumber % i == 0) {
                    validMultiple = true;
                } else {
                    validMultiple = false;
                    break;
                }
                if (i == numbersToMultiple) {
                    finalMultipleNumber = multipleNumber;
                }
            }
        }
        System.out.println("Final multiple number : " + finalMultipleNumber);
    }
}
