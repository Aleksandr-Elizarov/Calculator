package com.company.impl;

import com.company.ConstantsForCalculator;
import com.company.ReversePolishNotation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Class ReversePolishNotationImpl contains only a method for the creation
 * string representation of the reverse polish notation from the string passed to it.
 */
public class ReversePolishNotationImpl implements ReversePolishNotation {

    /**
     * Method only create a reverse polish notation.
     *
     * @param input - string that passed to method.
     * @return string representation of the reverse polish notation for next step.
     */
    public Deque<String> createRPN(String input) {
        char charInput;
        Deque<String> stackOut = new ArrayDeque<>();
        Deque<Character> stackOperations = new ArrayDeque<>();
        StringBuilder number = new StringBuilder("");
        for (int i = 0; i < input.length(); i++) {
            charInput = input.charAt(i);
            if (isOperator(charInput)) {
                addNumberToStack(number, stackOut);
                if (input.charAt(0) == charInput && charInput == '-') {
                    number.append(charInput);
                } else if (stackOperations.isEmpty()) {
                    stackOperations.push(charInput);
                } else if (charInput == ')') {
                    moveCharactersFromParenthesesToStack(stackOperations, stackOut);
                } else if (getPriority(charInput) <= getPriority(stackOperations
                        .getFirst()) && stackOperations.getFirst() != '(') {
                    moveLowPrioritySymbolsToStack(stackOperations, stackOut,
                            charInput);
                } else if (charInput == '-' && (input.charAt(i - 1)) == '(') {
                    number.append(charInput);
                } else {
                    stackOperations.push(charInput);
                }
            } else {
                number.append(charInput);
            }
        }
        addNumberToStack(number, stackOut);
        moveRemainingSymbolsToStack(stackOperations, stackOut);
        return stackOut;
    }

    /**
     * The method checks the entered character for the presence in the list
     * of allowed characters.
     *
     * @param c - is entered character.
     * @return true, if entered character contains in enum ConstantsForCalculator.
     */
    public static boolean isOperator(char c) {
        for (ConstantsForCalculator constants : ConstantsForCalculator.values()) {
            if (c == constants.symbol) {
                return true;
            }
        }
        return false;
    }

    /**
     * The method allows getting priority of the current character.
     *
     * @param op - is character that priority we need to get.
     * @return priority from the enum ConstantsForCalculator of this character.
     */
    private static byte getPriority(char op) {
        for (ConstantsForCalculator constants : ConstantsForCalculator.values()) {
            if (constants.symbol == op) {
                return (byte) constants.priority;
            }
        }
        return -1;
    }

    /**
     * The method allows adding next number to out stack.
     *
     * @param number   - one of the numbers collected from the characters of the
     *                 string.
     * @param stackOut - the representation of reverse polish notation that we
     *                 will calculate next step.
     */
    private static void addNumberToStack(StringBuilder number,
                                         Deque<String> stackOut) {
        String newDigit = new String(number);
        if (!newDigit.isEmpty()) {
            stackOut.add(newDigit);
            number.delete(0, number.length());
        }
    }

    /**
     * The method moves all remaining characters from right parenthesis till
     * left parenthesis to out stack.
     *
     * @param stackOperations - Stack that contains operation symbols.
     * @param stackOut        - The representation of reverse polish notation that we
     *                        will calculate next step.
     */
    private static void moveCharactersFromParenthesesToStack(Deque<Character> stackOperations,
                                                             Deque<String> stackOut) {
        while (stackOperations.getFirst() != '(') {
            stackOut.add(String.valueOf(stackOperations.pop()));
        }
        stackOperations.pop();
    }

    /**
     * The method moves low-priority or similary-priority characters
     * compared to current one to out stack .
     *
     * @param stackOperations - Stack that contains operation symbols.
     * @param stackOut        - The representation of reverse polish notation that we
     *                        will calculate next step.
     * @param charInput       - Current character compares to stackOperations.
     */
    private static void moveLowPrioritySymbolsToStack(Deque<Character> stackOperations,
                                                      Deque<String> stackOut, char charInput) {
        stackOut.add(String.valueOf(stackOperations.pop()));
        if (!stackOperations.isEmpty() && getPriority(charInput) == getPriority(stackOperations
                .getFirst())) {
            stackOut.add(String.valueOf(stackOperations.pop()));
        }
        stackOperations.push(charInput);
    }

    /**
     * The method moves remaining characters from stackOperations to out stack .
     *
     * @param stackOperations - Stack that contains operation symbols.
     * @param stackOut        - The representation of reverse polish notation that we
     *                        will calculate next step.
     */
    private static void moveRemainingSymbolsToStack(Deque<Character> stackOperations,
                                                    Deque<String> stackOut) {
        while (stackOperations.size() > 0) {
            stackOut.add(String.valueOf(stackOperations.pop()));
        }
    }
}