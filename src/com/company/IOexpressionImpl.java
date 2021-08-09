package com.company;

import java.util.Scanner;

/**
 *  Class IOexpressionImpl works with console, allows you to get a string expression that needs to calculate.
 *  And it also allows you to output result of the execution.
 */
public class IOexpressionImpl implements IOexpression {
    Scanner input = new Scanner(System.in);
    public String inputExp;

    public IOexpressionImpl() {
        System.out.println("Simple calculator." +
                "\nUse only Digits from 0 to 9,a dot as a separator, if it needs," +
                "and mathematical symbols +, / , - , * ." +
                "\nPlease enter the expression to calculate:" +
                "");
       try{
           inputExp = input.nextLine();
           if (inputExp == null || inputExp.isEmpty()) throw new IllegalArgumentException("You do not enter expression");
       }catch (Exception e){
           System.out.println(e.getMessage());;
       }

    }

    /**
     *
     * @param value result that calculates by the method calculate of the CalculatorImpl class,
     * for the presenting to users console.
     */
    public void resultOfCalculation(double value){
        System.out.println("Result of the expression: "+ value);
    }
}
