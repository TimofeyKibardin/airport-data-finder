package com.timofey.airport_data.input_validation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidInputImplementationTest {

    private ValidInputImplementation validInput;

    @Before
    public void setUp() {
        validInput = new ValidInputImplementation();
    }

    @Test
    public void testCheckIfArgsValidWhenZero() {
        String[] arguments = new String[]{"0"};
        assertFalse("Should be false", validInput.checkIfArgsValid(arguments));
    }

    @Test
    public void testCheckIfArgsValidWhenNegativeMeaning() {
        String[] arguments = new String[]{"-100"};
        assertFalse("Should be false", validInput.checkIfArgsValid(arguments));
    }

    @Test
    public void testCheckIfArgsValidWhenPositiveValueInRange() {
        String[] arguments = new String[]{"14"};
        assertTrue("Should be true", validInput.checkIfArgsValid(arguments));
    }

    @Test
    public void testCheckIfArgsValidWhenPositiveValueNotInRange() {
        String[] arguments = new String[]{"15"};
        assertFalse("Should be true", validInput.checkIfArgsValid(arguments));
    }

}
