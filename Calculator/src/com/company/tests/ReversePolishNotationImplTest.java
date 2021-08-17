package com.company.tests;

import com.company.ReversePolishNotation;
import com.company.ReversePolishNotationImpl;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ReversePolishNotationImplTest {

    ReversePolishNotation reversePolishNotation = new ReversePolishNotationImpl();

    @Test
    void createRPN_shouldParseInputString_toReversePolishNotationRepresentation() {
        List<Deque<String>> createdRPN = new ArrayList<>();
        createdRPN.add(new ArrayDeque<>(Arrays.asList("3", "4", "+")));
        createdRPN.add(new ArrayDeque<>(Arrays.asList("2", "7", "*", "5", "-")));
        createdRPN.add(new ArrayDeque<>(Arrays.asList("3", "4", "/", "8", "2", "*", "+")));
        List<String> inputString = new ArrayList<>();
        inputString.add("3+4");
        inputString.add("2*7-5");
        inputString.add("3/4+8*2");
        for (String line : inputString) {
            assertEquals((createdRPN.get(inputString.indexOf(line))).toString(), (reversePolishNotation.createRPN(line)).toString());
        }
    }

    @Test
    void isOperator_shouldReturnTrue() {
        assertTrue(ReversePolishNotationImpl.isOperator('-'));
        assertTrue(ReversePolishNotationImpl.isOperator('+'));
        assertTrue(ReversePolishNotationImpl.isOperator('/'));
        assertTrue(ReversePolishNotationImpl.isOperator('*'));
    }

    @Test
    void isOperator_shouldReturnFalse() {
        assertFalse(ReversePolishNotationImpl.isOperator('%'));
        assertFalse(ReversePolishNotationImpl.isOperator('!'));
        assertFalse(ReversePolishNotationImpl.isOperator('e'));
        assertFalse(ReversePolishNotationImpl.isOperator('?'));
    }
}