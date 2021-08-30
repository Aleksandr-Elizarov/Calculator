package com.company.impl;

import com.company.IOExpression;

import java.util.Locale;
import java.util.Scanner;

/**
 * Class IOExpressionImpl works with console, allows you to get a string expression that needs to calculate.
 * And it also allows you to output result of the execution.
 */
public class IOExpressionImpl implements IOExpression {
    public String inputExp;
    public boolean start = true;

    public IOExpressionImpl() {
        System.out.println("\nSimple calculator." +
                "\nPlease use Digits from 0 to 9 and a dot as a separator for" +
                " real numbers." +
                "\nMathematical operations +, / , - , *  and left ) or right " +
                "( parentheses." +
                "\nTake negative numbers in parentheses, like: (-3)*" +
                "(-7.45)." +
                "\nPlease enter the expression to calculate: ");
        createNewCommandLine();
        if (inputExp == null || inputExp.isEmpty()) {
            throw new IllegalArgumentException("You do not enter expression!");
        }
        try {
            Double.parseDouble(inputExp);
            throw new IllegalArgumentException("You need at least 2 numbers" +
                    " for the expression!");
        } catch (NumberFormatException ignored) {
        }
    }

    /**
     * @param value result that calculates by the method calculate
     *              of the CalculatorImpl class, for the presenting
     *              to users console.
     */
    public void resultOfCalculation(double value) {
        System.out.println("Result of the expression: " + value +
                "\nIf you need to calculate another expression," +
                " please enter it. For quit, enter q.");
        createNewCommandLine();
    }

    /**
     * Method creates a new line for the entering the expression.
     */
    public void createNewCommandLine() {
        inputExp = new Scanner(System.in).nextLine();
        if (inputExp.toLowerCase(Locale.ROOT).equals("q")) {
            System.exit(0);
        }

    }
}
