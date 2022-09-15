import java.util.Scanner;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 **/
public class PythagoreanTriplet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Finding magic triplet with in ");
        int maxNum = scanner.nextInt();
        System.out.println("Sum of magic triplet should be");
        int magicSum = scanner.nextInt();
        boolean magicTriplet = false;

        for (int firstNum = 1; firstNum <= maxNum; firstNum++) {
            if (magicTriplet) {
                break;
            }
            for (int secondNum = firstNum + 1; secondNum <= maxNum; secondNum++) {
                for (int thirdNum = secondNum + 1; thirdNum <= maxNum; thirdNum++) {
                    if (firstNum + secondNum + thirdNum == magicSum) {
                        var firstTripletNum = firstNum * firstNum;
                        var secondTripletNum = secondNum * secondNum;
                        var thirdTripletNum = thirdNum * thirdNum;
                        var isTriplet = false;
                        if (firstTripletNum + secondTripletNum == thirdTripletNum) {
                            isTriplet = true;
                        } else if (secondTripletNum + thirdTripletNum == firstTripletNum) {
                            isTriplet = true;
                        } else if (firstTripletNum + thirdTripletNum == secondTripletNum) {
                            isTriplet = true;
                        }
                        if (isTriplet) {
                            System.out.println("magic Triplet : " + firstNum + " " + secondNum + " " + thirdNum);
                            magicTriplet = true;
                            System.out.println("magic triplet abc: " + firstNum * secondNum * thirdNum);
                            break;
                        }
                    }
                }
            }
        }
    }
}
