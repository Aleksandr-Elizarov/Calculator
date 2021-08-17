package com.company.tests;

import com.company.Validator;
import com.company.ValidatorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorImplTest {

    Validator validator = new ValidatorImpl();

    @Test
    void validator_shouldReturnTrue() {
        assertTrue(validator.validate("3+4"));
        assertTrue(validator.validate("3+4.06"));
        assertTrue(validator.validate("3+4*3-7/2"));
        assertTrue(validator.validate("1-2+3/4"));
        assertTrue(validator.validate("3.3333*433.4244"));
        assertTrue(validator.validate("0.5464-43434*333"));
    }

    @Test
    public void validator_shouldThrowException_ifExpressionHasAnErrorAtTheBeginning() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate("-3+4"));
    }

    @Test
    public void validator_shouldThrowException_ifExpressionHas_twoOrMoreConsecutiveCharacters() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate("3++4"));
    }

    @Test
    public void validator_shouldThrowException_ifExpressionContains_extraCharacters() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate("error3+4"));
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate("(3)3+4"));
    }

    @Test
    public void validator_shouldThrowException_ifExpressionContains_moreThanOneDotInTheNumbers() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate("3+4..22"));
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate("3+4.22.333*3"));
    }

    @Test
    public void validator_shouldThrowException_ifExpressionHasAnErrorInTHeEnd() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate("3+4+"));
    }
}