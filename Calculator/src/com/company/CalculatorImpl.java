package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.company.ConstantsForCalculator.*;
import static com.company.ReversePolishNotationImpl.isOperator;

/**
* Class CalculatorIpl execute mathematical operations like addition, subtraction, division
* and multiplication, with expression given as string representation of a reverse polish notation.
*/
public class CalculatorImpl implements Calculator {


    /**
     * Method calculate executed mathematical operations like addition, subtraction, division
     * and multiplication.
     * @param rpn given string representation of a reverse polish notation.
     * @return result of mathematical operations as double value.
     */
    public double calculate(Deque<String> rpn){
        double firstDigit, secondDigit;
        char firstChar;
        Deque<Double> stack = new ArrayDeque<>();
        for (String value : rpn) {
            firstChar = value.charAt(0);
            if(isOperator(firstChar)){
                secondDigit = stack.pop();
                firstDigit = stack.pop();
                if(firstChar == ADDITION.symbol) {
                    firstDigit += secondDigit;
                }else if(firstChar == SUBTRACTION.symbol) {
                    firstDigit -= secondDigit;
                }else if(firstChar == MULTIPLICATION.symbol) {
                    firstDigit *= secondDigit;
                }else if(firstChar == DIVISION.symbol) {
                    if (secondDigit == 0) {
                        throw new ArithmeticException("Division by zero are not allowed!");
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