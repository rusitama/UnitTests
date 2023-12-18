import static org.junit.jupiter.api.Assertions.*;

import org.example.NumberChecker;
import org.junit.jupiter.api.Test;

class NumberCheckerTest {

    //Задание 1
    @Test
    void testEvenNumber() {
        NumberChecker checker = new NumberChecker();
        assertTrue(checker.evenOddNumber(4), "The method should return true for even numbers.");
    }

    @Test
    void testOddNumber() {
        NumberChecker checker = new NumberChecker();
        assertFalse(checker.evenOddNumber(7), "The method should return false for odd numbers.");
    }

    @Test
    void testZero() {
        NumberChecker checker = new NumberChecker();
        assertTrue(checker.evenOddNumber(0), "The method should return true for zero.");
    }

    @Test
    void testNegativeEvenNumber() {
        NumberChecker checker = new NumberChecker();
        assertTrue(checker.evenOddNumber(-8), "The method should return true for negative even numbers.");
    }

    @Test
    void testNegativeOddNumber() {
        NumberChecker checker = new NumberChecker();
        assertFalse(checker.evenOddNumber(-11), "The method should return false for negative odd numbers.");
    }

    //Задание 2
    @Test
    void testNumberInInterval() {
        NumberChecker checker = new NumberChecker();
        assertTrue(checker.numberInInterval(50), "The method should return true for a number in the interval (25;100).");
        assertTrue(checker.numberInInterval(26), "The method should return true for a number in the interval (25;100).");
        assertTrue(checker.numberInInterval(99), "The method should return true for a number in the interval (25;100).");
    }

    @Test
    void testNumberBelowInterval() {
        NumberChecker checker = new NumberChecker();
        assertFalse(checker.numberInInterval(24), "The method should return false for a number below the interval.");
    }

    @Test
    void testNumberAboveInterval() {
        NumberChecker checker = new NumberChecker();
        assertFalse(checker.numberInInterval(101), "The method should return false for a number above the interval.");
    }

    @Test
    void testNumberAtLowerBound() {
        NumberChecker checker = new NumberChecker();
        assertFalse(checker.numberInInterval(25), "The method should return false for a number at the lower bound of the interval.");
    }

    @Test
    void testNumberAtUpperBound() {
        NumberChecker checker = new NumberChecker();
        assertFalse(checker.numberInInterval(100), "The method should return false for a number at the upper bound of the interval.");
    }
}
