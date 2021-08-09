package com.company.tests;

import com.company.Calculator;
import com.company.CalculatorImpl;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CalculatorImplTest {

    Calculator calculator = new CalculatorImpl();

    @Test
    void calculator_shouldReturnDoubleValue_ofMathematicalOperations() {
        List<Double> actualValues = new ArrayList<>();
        actualValues.add(7.55);
        actualValues.add(9.0);
        actualValues.add(16.75);
        actualValues.add(-65.5);
        List<Deque<String>> currentRPN = new ArrayList<>();
        currentRPN.add(new ArrayDeque<>(Arrays.asList("3", "4.55", "+")));
        currentRPN.add(new ArrayDeque<>(Arrays.asList("2", "7", "*", "5", "-")));
        currentRPN.add(new ArrayDeque<>(Arrays.asList("3", "4", "/", "8", "2", "*", "+")));
        currentRPN.add(new ArrayDeque<>(Arrays.asList("1", "7", "3", "*", "2", "/", "-", "7", "8", "*", "-")));
        for(Deque<String> rpn : currentRPN){
            assertEquals(actualValues.get(currentRPN.indexOf(rpn)), calculator.calculate(rpn));
        }

    }
    @Test
    public void calculator_shouldThrowException_onDivisionByZero(){
        assertThrows(ArithmeticException.class,
                ()->calculator.calculate(new ArrayDeque<>(Arrays.asList("3", "0", "/"))));
    }
}