package com.company;

public class main {
    public static void main(String[] args){
        IOexpressionImpl exp = new IOexpressionImpl();
        Validator validator = new ValidatorImpl();
        ReversePolishNotationImpl rpn = new ReversePolishNotationImpl();
        CalculatorImpl calc = new CalculatorImpl();
        validator.validate(exp.inputExp);
        exp.resultOfCalculation(calc.calculate(rpn.createRPN(exp.inputExp)));
    }
}
