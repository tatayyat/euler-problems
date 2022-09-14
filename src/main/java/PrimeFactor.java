import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/***
 * Find out the largest prime factor of the given number 600851475143L
 */
public class PrimeFactor {
    public static void main(String[] args) {
        printLargestPrimeFactor(600851475143L);
    }

    static void printLargestPrimeFactor(long factNum) {
        List<Integer> factors = new ArrayList<>();
        for (var i = 2; i < Math.sqrt(factNum); i++) {
            if (factNum % i == 0) {
                factors.add(i);
            }
        }
        System.out.println("Factors of : " + factNum + " is " + factors);
        List<Integer> primeFactors = factors.stream().filter(p -> BigInteger.valueOf(p).isProbablePrime(100)).collect(Collectors.toList());

        System.out.println("Prime Factors of : " + factNum + " is " + primeFactors);
        System.out.println("Largest Prime Factor of the number: " + factNum + " is " + Collections.max(primeFactors));
    }
}
