package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    private final Calculator calculator = new Calculator();

    @Test
    void positiveEvenNumberReturnsTrue() {
        assertTrue(calculator.isEven(4));
    }

    @Test
    void positiveOddNumberReturnsFalse() {
        assertFalse(calculator.isEven(5));
    }

    @Test
    void zeroReturnsTrue() {
        assertTrue(calculator.isEven(0));
    }

    @Test
    void negativeEvenNumberReturnsTrue() {
        assertTrue(calculator.isEven(-8));
    }

    @Test
    void negativeOddNumberReturnsFalse() {
        assertFalse(calculator.isEven(-3));
    }

    @Test
    void integerLimitsAreHandled() {
        assertTrue(calculator.isEven(Integer.MIN_VALUE));
        assertFalse(calculator.isEven(Integer.MAX_VALUE));
    }
}