package com.company;


public enum ConstantsForCalculator {
    ADDITION('+', 1),
    SUBTRACTION('-', 1),
    MULTIPLICATION('*', 2),
    DIVISION('/', 2),
    LEFT_PARENTHESIS('(', 3),
    RIGHT_PARENTHESIS(')', 3);
    public int priority;
    public char symbol;

    ConstantsForCalculator(char symbol, int priority) {
        this.priority = priority;
        this.symbol = symbol;
    }

}


