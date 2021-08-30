package com.company.impl;

import com.company.Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.company.ConstantsForCalculator.*;
import static com.company.impl.ReversePolishNotationImpl.isOperator;

/**
 * Class CalculatorIpl execute mathematical operations like addition,
 * subtraction, division
 * and multiplication, with expression given as string representation
 * of a reverse polish notation.
 */
public class CalculatorImpl implements Calculator {


    /**
     * Method calculate executed mathematical operations like addition,
     * subtraction, division
     * and multiplication.
     *
     * @param rpn given string representation of a reverse polish notation.
     * @return result of mathematical operations as double value.
     */
    public double calculate(Deque<String> rpn) {
        double firstDigit, secondDigit;
        char firstChar;
        int stringLength;
        Deque<Double> stack = new ArrayDeque<>();
        for (String value : rpn) {
            stringLength = value.length();
            firstChar = value.charAt(0);
            if (isOperator(firstChar) && stringLength == 1) {
                secondDigit = stack.pop();
                firstDigit = stack.pop();
                if (firstChar == ADDITION.symbol) {
                    firstDigit += secondDigit;
                } else if (firstChar == SUBTRACTION.symbol) {
                    firstDigit -= secondDigit;
                } else if (firstChar == MULTIPLICATION.symbol) {
                    firstDigit *= secondDigit;
                } else if (firstChar == DIVISION.symbol) {
                    if (secondDigit == 0) {
                        try {
                            throw new ArithmeticException("Division by zero" +
                                    " are not allowed!");
                        } catch (ArithmeticException e) {
                            System.out.println("Division by zero" +
                                    " are not allowed!");
                        }

                    }
                    firstDigit /= secondDigit;
                }
            } else {
                firstDigit = Double.parseDouble(value);
            }
            stack.push(firstDigit);
        }
        return stack.pop();
    }
}