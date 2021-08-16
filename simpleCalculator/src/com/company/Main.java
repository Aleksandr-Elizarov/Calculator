package com.company;

public class Main {
    public static void main(String[] args){
        IOExpressionImpl exp = new IOExpressionImpl();
        Validator validator = new ValidatorImpl();
        ReversePolishNotationImpl rpn = new ReversePolishNotationImpl();
        CalculatorImpl calc = new CalculatorImpl();
        validator.validate(exp.inputExp);
        exp.resultOfCalculation(calc.calculate(rpn.createRPN(exp.inputExp)));
    }
}
