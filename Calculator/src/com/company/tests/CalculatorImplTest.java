package com.company.tests;

import com.company.Calculator;
import com.company.impl.CalculatorImpl;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorImplTest {

    Calculator calculator = new CalculatorImpl();

    @Test
    void calculator_shouldReturnDoubleValue_ofMathematicalOperations() {
        List<Double> actualValues = new ArrayList<>();
        actualValues.add(7.55);
        actualValues.add(9.0);
        actualValues.add(16.75);
        actualValues.add(-65.5);
        actualValues.add(19.0);
        actualValues.add(-252.0);
        actualValues.add(12.0);
        actualValues.add(12.0);
        actualValues.add(204.0);
        List<Deque<String>> currentRPN = new ArrayList<>();
        currentRPN.add(new ArrayDeque<>(Arrays.asList("3", "4.55", "+")));
        currentRPN.add(new ArrayDeque<>(Arrays.asList("2", "7", "*", "5", "-")));
        currentRPN.add(new ArrayDeque<>(Arrays.asList("3", "4", "/", "8", "2",
                "*", "+")));
        currentRPN.add(new ArrayDeque<>(Arrays.asList("1", "7", "3", "*", "2",
                "/", "-", "7", "8", "*", "-")));
        currentRPN.add(new ArrayDeque<>(Arrays.asList("2", "7", "-", "3", "*"
                , "4", "+", "6", "2", "7", "-", "*", "-")));
        currentRPN.add(new ArrayDeque<>(Arrays.asList("3", "3", "+", "2", "4"
                , "-", "4", "4", "4", "+", "*", "-", "3", "7", "-", "2", "*",
                "+", "*")));
        currentRPN.add(new ArrayDeque<>(Arrays.asList("-4", "3", "*", "4", "2"
                , "8", "-", "*", "-")));
        currentRPN.add(new ArrayDeque<>(Arrays.asList("-2", "-4", "3.5", "*",
                "-")));
        currentRPN.add(new ArrayDeque<>(Arrays.asList("-3", "-4", "-3", "-20",
                "-", "*", "*")));
        for (Deque<String> rpn : currentRPN) {
            assertEquals(actualValues.get(currentRPN.indexOf(rpn)), calculator.calculate(rpn));
        }

    }

    @Test
    public void calculator_shouldReturnInfinity_onDivisionByZero() {
        assertEquals(Double.POSITIVE_INFINITY,
                calculator.calculate(new ArrayDeque<>(Arrays.asList(
                        "3", "0", "/"))));
        assertEquals(Double.NEGATIVE_INFINITY,
                calculator.calculate(new ArrayDeque<>(Arrays.asList(
                        "-3", "4", "4", "-", "/"))));
    }
}