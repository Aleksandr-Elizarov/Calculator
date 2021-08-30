package com.company;

import com.company.impl.CalculatorImpl;
import com.company.impl.IOExpressionImpl;
import com.company.impl.ReversePolishNotationImpl;
import com.company.impl.ValidatorImpl;

public class Main {
    public static void main(String[] args) {
        IOExpressionImpl exp = new IOExpressionImpl();
        Validator validator = new ValidatorImpl();
        ReversePolishNotation rpn = new ReversePolishNotationImpl();
        Calculator calc = new CalculatorImpl();
        while (exp.start) {
            if (validator.validate(exp.inputExp)) {
                exp.resultOfCalculation(calc.calculate(rpn.createRPN(exp.inputExp)));
            } else {
                exp.createNewCommandLine();
            }
        }
    }
}
