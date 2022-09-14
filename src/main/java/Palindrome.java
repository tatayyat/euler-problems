import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;

/***
 * Solution for : A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.*
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Palindrome {
    public static void main(String[] args) {
        printLargestPalindrome(1000);
    }

    static void printLargestPalindrome(int maxNumber) {
        List<NumbersList> numbersLists = new ArrayList<>();
        for (var firstKey = 1; firstKey < maxNumber; firstKey++) {
            for (var secondKey = 1; secondKey < maxNumber; secondKey++) {
                numbersLists.add(new NumbersList(firstKey, secondKey));
            }
        }
        List<Integer> palindromes = new ArrayList<>();
        for (NumbersList numbersList : numbersLists) {
            Integer multipliedVal = numbersList.getFirstNumber() * numbersList.getSecondNumber();
            StringBuilder multipliedValStr = new StringBuilder(String.valueOf(multipliedVal));
            if (multipliedValStr.reverse().toString().equals(String.valueOf(multipliedVal))) {
                palindromes.add(multipliedVal);
            }
        }
        System.out.println("Palindromes from 1 to " + maxNumber + "  is :  " + palindromes);
        OptionalInt maxPalindrome = palindromes.stream()
                .mapToInt(Integer::intValue).max();
        if (maxPalindrome.isPresent()) {
            System.out.println("The largest palindrome made from the given max numbers is  :  " + maxPalindrome.getAsInt());
        }
    }
}

class NumbersList {
    private final int firstNumber;
    private final int secondNumber;

    public NumbersList(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumbersList that = (NumbersList) o;
        return firstNumber == that.firstNumber && secondNumber == that.secondNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNumber, secondNumber);
    }
}
