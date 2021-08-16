package com.company;

public class Main {
    public static void main(String[] args) {
        Validator validator = new ValidatorImpl();
        ReversePolishNotationImpl rpn = new ReversePolishNotationImpl();
        CalculatorImpl calc = new CalculatorImpl();
        while (IOExpressionImpl.start) {
            IOExpressionImpl exp = new IOExpressionImpl();
            validator.validate(exp.inputExp);
            exp.resultOfCalculation(calc.calculate(rpn.createRPN(exp.inputExp)));
        }
    }
}
