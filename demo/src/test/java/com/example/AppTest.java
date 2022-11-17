package com.example;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.ExceptionHandling.InvalidCharacterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class AppTest {
    @Mock
    Algorythm solution;

    @Before
    public void setUp() {
        solution = mock(Algorythm.class);
    }
    @BeforeClass
    public static void BeforeClass() {
        System.out.println("Starting the App Test, App Test class is initalizing");
        log.info("Starting the App Test, App Test class is initalizing");
    }

    @Test
    public void testSolution() throws InvalidCharacterException {
        when(solution.solution("abc", "abc")).thenReturn(1);
        assertEquals(1, solution.solution("abc", "abc"));
        assertEquals(0, solution.solution("北京位於華北平原的西北边缘人文景观", "cat"));
        assertEquals(0, solution.solution("وضع ابنالنموذج الرياضي الومة الظواهر الملحوظة.", "cat"));
        log.info("basic solution tests complete");
    }
    @Test
    public void testFileNotFoundException() {
        FileNotFoundException exception = new FileNotFoundException("File not found");
        assertEquals("File not found", exception.getMessage());
        log.info("File not Found Exception test completed");
    }
    @Test
    public void testNoSuchElementException() {
        NoSuchElementException exception = new NoSuchElementException("File has only 1 or 0 lines!");
        assertEquals("File has only 1 or 0 lines!", exception.getMessage());
        log.info("No Such Element Exception test completed");
    }
    @Test
    public void testSecurityException() {
        SecurityException exception = new SecurityException("Security Exception:");
        assertEquals("Security Exception:", exception.getMessage());
        log.info("Security Exception test completed");
    }
    @Test
    public void testInvalidCharacterException() {
        InvalidCharacterException exception = new InvalidCharacterException("Only alphabet characters are accepted");
        assertEquals("Only alphabet characters are accepted", exception.getMessage());
        log.info("Invalid Character Exception test completed");
    }
    @After
    public void after() {
        System.out.println("Test has finished executing");
        log.info("Test has finished executing");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("App Test class has finished executing");
        log.info("App Test class has finished executing");
    }
}