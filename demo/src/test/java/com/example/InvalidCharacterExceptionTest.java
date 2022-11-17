package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.ExceptionHandling.InvalidCharacterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class InvalidCharacterExceptionTest {
    @BeforeClass
    public static void BeforeClass() {
        System.out.println("Invalid Character Exception test has started executing and the test class is being created");
        log.info("Invalid Character Exception test has started executing and the test class is being created");
        
    }
    @Test
    public void testInvalidCharacterException() {
        InvalidCharacterException exception = new InvalidCharacterException("Only alphabet characters are accepted");
        assertEquals("Only alphabet characters are accepted", exception.getMessage());
    }
    @AfterClass
    public static void AfterClass() {
        System.out.println("Test class for invalid Character Exception hes finished");
        log.info("Test class for invalid Character Exception hes finished");
    }
}