package com.company;


public enum ConstantsForCalculator {
    ADDITION('+', 1),
    SUBTRACTION('-', 1),
    MULTIPLICATION('*', 2),
    DIVISION('/', 2);
    int priority;
    char symbol;

    ConstantsForCalculator(char symbol, int priority) {
        this.priority = priority;
        this.symbol = symbol;
    }

}


