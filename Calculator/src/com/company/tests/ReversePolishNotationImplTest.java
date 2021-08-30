package com.company.tests;

import com.company.ReversePolishNotation;
import com.company.impl.ReversePolishNotationImpl;
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
        createdRPN.add(new ArrayDeque<>(Arrays.asList("3", "4", "/", "8", "2",
                "*", "+")));
        createdRPN.add(new ArrayDeque<>(Arrays.asList("2", "7", "-", "3", "*"
                , "4", "+", "6", "2", "7", "-", "*", "-")));
        createdRPN.add(new ArrayDeque<>(Arrays.asList("3", "3", "+", "2", "4"
                , "-", "4", "4", "4", "+", "*", "-", "3", "7", "-", "2", "*",
                "+", "*")));
        createdRPN.add(new ArrayDeque<>(Arrays.asList("-4", "3", "*", "4", "2"
                , "8", "-", "*", "-")));
        createdRPN.add(new ArrayDeque<>(Arrays.asList("-2", "-4", "3.5", "*", "-")));
        createdRPN.add(new ArrayDeque<>(Arrays.asList("-3", "-4", "-3", "-20",
                "-", "*", "*")));
        List<String> inputString = new ArrayList<>();
        inputString.add("3+4");
        inputString.add("2*7-5");
        inputString.add("3/4+8*2");
        inputString.add("(2-7)*3+4-6*(2-7)");
        inputString.add("(3+3)*(2-4-4*(4+4)+(3-7)*2)");
        inputString.add("(-4)*3-4*(2-8)");
        inputString.add("(-2)-((-4)*3.5)");
        inputString.add("(-3)*((-4)*((-3)-(-20)))");
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
        assertTrue(ReversePolishNotationImpl.isOperator('('));
        assertTrue(ReversePolishNotationImpl.isOperator(')'));
    }

    @Test
    void isOperator_shouldReturnFalse() {
        assertFalse(ReversePolishNotationImpl.isOperator('%'));
        assertFalse(ReversePolishNotationImpl.isOperator('!'));
        assertFalse(ReversePolishNotationImpl.isOperator('e'));
        assertFalse(ReversePolishNotationImpl.isOperator('?'));
    }
}