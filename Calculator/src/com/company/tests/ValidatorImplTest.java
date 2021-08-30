package com.company.tests;

import com.company.Validator;
import com.company.impl.ValidatorImpl;
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
        assertTrue(validator.validate("(3+3)*(2-4-4*(4+4)+(3-7)*2)"));
        assertTrue(validator.validate("(2-7)*3+4-6*(2-7)"));
        assertTrue(validator.validate("(-4)*3-4*(2-8)"));
        assertTrue(validator.validate("(-2)-((-4)*3.5)"));
        assertTrue(validator.validate("(-3)*((-4)*((-3)-(-20)))"));
    }

    @Test
    public void validator_shouldReturnFalse_ifExpressionHasAnErrorAtTheBeginning() {
        assertFalse(validator.validate("*3+4"));
    }

    @Test
    public void validator_shouldReturnFalse_ifExpressionHas_twoOrMoreConsecutiveCharacters() {
        assertFalse(validator.validate("3++4"));
    }

    @Test
    public void validator_shouldReturnFalse_ifExpressionContains_extraCharacters() {
        assertFalse(validator.validate("error3+4"));
        assertFalse(validator.validate("[3]3+4"));
    }

    @Test
    public void validator_shouldReturnFalse_ifExpressionContains_moreThanOneDotInTheNumbers() {
        assertFalse(validator.validate("3+4..22"));
        assertFalse(validator.validate("3+4.22.333*3"));
    }

    @Test
    public void validator_shouldReturnFalse_ifExpressionHasAnErrorInTHeEnd() {
        assertFalse(validator.validate("3+4+"));
    }

    @Test
    public void validator_shouldReturnFalse_ifExpressionHasAnErrorsInParentheses() {
        assertFalse(validator.validate("(3)+4+"));
        assertFalse(validator.validate("(+3-)+4+"));
        assertFalse(validator.validate("(/3)+4+"));
        assertFalse(validator.validate("(*3+)+4+()"));
        assertFalse(validator.validate("(3+)+4+"));
        assertFalse(validator.validate("()4"));
    }
}