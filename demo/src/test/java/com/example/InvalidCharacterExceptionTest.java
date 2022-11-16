package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.example.ExceptionHandling.InvalidCharacterException;

public class InvalidCharacterExceptionTest {
    @Test
    public void testInvalidCharacterException() {
        InvalidCharacterException exception = new InvalidCharacterException("Only alphabet characters are accepted");
        assertEquals("Only alphabet characters are accepted", exception.getMessage());
    }
}