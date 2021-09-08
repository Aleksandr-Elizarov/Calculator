package com.company;

import com.company.impl.CalculatorImpl;
import com.company.impl.IOExpressionImpl;
import com.company.impl.ReversePolishNotationImpl;
import com.company.impl.ValidatorImpl;

public class Main {
    public static void main(String[] args) {
        IOExpression exp = new IOExpressionImpl();
        Validator validator = new ValidatorImpl();
        ReversePolishNotation rpn = new ReversePolishNotationImpl();
        Calculator calc = new CalculatorImpl();
        while (true) {
            if (validator.validate(exp.getInputExp())) {
                exp.resultOfCalculation(calc.calculate(rpn.createRPN(exp.getInputExp())));
            } else {
                exp.createNewCommandLine();
            }
        }
    }
}
