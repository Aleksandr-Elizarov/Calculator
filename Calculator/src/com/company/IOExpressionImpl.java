package com.company;

import java.util.Locale;
import java.util.Scanner;

/**
 *  Class IOExpressionImpl works with console, allows you to get a string expression that needs to calculate.
 *  And it also allows you to output result of the execution.
 */
public class IOExpressionImpl implements IOExpression {
    public String inputExp;
    public static boolean start = true;

    public IOExpressionImpl() {
        System.out.println("\nSimple calculator." +
                "\nUse only Digits from 0 to 9,a dot as a separator, if it needs," +
                "and mathematical symbols +, / , - , * ." +
                "\nPlease enter the expression to calculate: ");
        inputExp = new Scanner(System.in).nextLine();
        if (inputExp == null || inputExp.isEmpty()) {
            throw new IllegalArgumentException("You do not enter expression!");
        }
        try{
            Double.parseDouble(inputExp);
            throw new IllegalArgumentException("You need at least 2 numbers for the expression!");
        } catch (NumberFormatException ignored) {
        }
    }

    /**
     *
     * @param value result that calculates by the method calculate of the CalculatorImpl class,
     * for the presenting to users console.
     */
    public void resultOfCalculation(double value){
        System.out.println("Result of the expression: "+ value +
        "\nIf you need to calculate a new expression, please enter any letter. For quit, enter q.");
        inputExp = new Scanner(System.in).nextLine();
        if(inputExp.toLowerCase(Locale.ROOT).equals("q")){
            System.exit(0);
        }
    }
}
