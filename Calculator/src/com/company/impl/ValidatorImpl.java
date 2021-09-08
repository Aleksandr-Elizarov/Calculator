package com.company.impl;

import com.company.Validator;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class contains method and constants to check the expression for errors.
 */
public class ValidatorImpl implements Validator {

    /**
     * A new prompt that is sent if there are errors in the expression.
     */
    public static final String NEW_INVITATION = "\nIf you need to calculate" +
            " another expression," +
            " please enter it. For quit, enter q.";
    /**
     * dot or mathematical symbols(+ ,- ,/ ,*) are at the beginning
     * of the expression.
     */
    public static final String ERROR_AT_THE_BEGINNING = "^[-+/*.]";
    /**
     * two or more consecutive characters (dot,+ ,- ,/ ,*) are in the
     * expression.
     */
    public static final String ERROR_DOUBLED_SYMBOLS = "[.+\\-*/]{2,10}";
    /**
     * two or more dots are in a number in the expression
     */
    public static final String ERROR_EXTRA_POINTS = "\\.?\\d+\\.+\\d+\\.";
    /**
     * expression contains letters and another not allowed symbol like
     * parenthesis, square braces, @, !, %, and ect.
     */
    public static final String ERROR_EXTRA_CHAR = "[^\\d./+\\-*()]";
    /**
     * dot or mathematical symbols(dot,+ ,- ,/ ,*) in the end of the expression.
     */
    public static final String ERROR_IN_THE_END = "[+\\-/*.]$";
    /**
     * expression error in parentheses.
     */
    public static final String ERROR_PARENTHESIS = "\\([+*/]?\\d?[+*/]?\\)";

    /**
     * Method check given string for errors
     * which will not allow you to convert the string to the reverse Polish notation.
     * In fact, it checks the user's errors in the mathematical expression.
     *
     * @param line that will check on the errors.
     * @return true if expression doesn't contain errors:
     */
    public boolean validate(String line) {
        StringBuilder sb = new StringBuilder();
        try {
            Pattern errors = Pattern.compile(ERROR_AT_THE_BEGINNING + "|" +
                    ERROR_DOUBLED_SYMBOLS + "|" + ERROR_EXTRA_POINTS + "|" +
                    ERROR_EXTRA_CHAR + "|" + ERROR_PARENTHESIS + "|" +
                    ERROR_IN_THE_END);
            Matcher e = errors.matcher(line);
            while (e.find()) {
                sb.append("   ").append(line, e.start(), e.end()).append(" ");
            }
            if (!sb.toString().isEmpty()) {
                throw new IllegalArgumentException("Invalid symbols " + sb);
            }
            if (matchingParenthesis(line) != 0) {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            System.out.println("The number of parenthesis is not matched!" +
                    NEW_INVITATION);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("You made a mistake! Invalid symbols   " + sb +
                    "\nAllowed only +, -, ., *, / (not twice dots, for example)" +
                    " and digits from 0 to 9." +
                    NEW_INVITATION);
            return false;

        }
        return true;
    }

    /**
     * Method check given string for matching of parentheses.
     *
     * @param line that will check on the parentheses.
     * @return 1 if left parentheses more than right,
     * return -1 if right parentheses more than left,
     * returns 0 if the number of parentheses is equal to.
     */
    private static int matchingParenthesis(String line) {
        int leftParenthesis = 0;
        int rightParenthesis = 0;
        Pattern matchingLP = Pattern.compile("\\(");
        Pattern matchingRP = Pattern.compile("\\)");
        Matcher lP = matchingLP.matcher(line);
        while (lP.find()) {
            leftParenthesis++;
        }
        Matcher rP = matchingRP.matcher(line);
        while (rP.find()) {
            rightParenthesis++;
        }
        return Integer.compare(leftParenthesis, rightParenthesis);
    }
}

