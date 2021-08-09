package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Class ReversePolishNotationImpl contains only a method for the creation
 * string representation of the reverse polish notation from the string passed to it.
 */
public class ReversePolishNotationImpl implements ReversePolishNotation {
    /**
     * Method only create a reverse polish notation.
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
                if (isOperator(charInput) ) {
                    stackOut.add(String.valueOf(number));
                    number.delete(0, number.length());
                    if(stackOperations.isEmpty()){
                        stackOperations.push(charInput);
                    }else if (getPriority(charInput) <= getPriority(stackOperations.getFirst())){
                        stackOut.add(String.valueOf(stackOperations.pop()));
                        if(!stackOperations.isEmpty() && getPriority(charInput) == getPriority(stackOperations.getFirst())){
                            stackOut.add(String.valueOf(stackOperations.pop()));
                        }
                        stackOperations.push(charInput);
                    }else {
                        stackOperations.push(charInput);
                    }
                } else {
                    number.append(charInput);
                }
            }
            stackOut.add(String.valueOf(number));
            while (stackOperations.size() > 0) {
                stackOut.add(String.valueOf(stackOperations.pop()));
            }

            return stackOut;
    }

    /**
     * The method checks the entered character for the presence in the list of allowed characters.
     * @param c - is entered character.
     * @return true, if entered character contains in enum ConstantsForCalculator.
     */
    public static boolean isOperator(char c) {
        for (ConstantsForCalculator constants : ConstantsForCalculator.values()) {
            if(c == constants.symbol){
                return true;
            }
        }
        return false;
    }

    /**
     * The method allows to get priority of the current character.
     * @param op - is character that priority we need to get.
     * @return priority from the enum ConstantsForCalculator of this character.
     */
    private static byte getPriority(char op) {
        for(ConstantsForCalculator constants : ConstantsForCalculator.values()){
            if(constants.symbol == op){
                return (byte) constants.priority;
            }
        }
        return -1;
    }
}
