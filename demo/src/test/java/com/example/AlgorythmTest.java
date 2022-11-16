package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AlgorythmTest {
    @Test
    public void testSolution() {
        Algorythm solution = new Algorythm();
        assertEquals(0, solution.solution("", ""));
        assertEquals(0, solution.solution("", "a"));
        assertEquals(0, solution.solution("a", ""));
        assertEquals(0, solution.solution("a", "b"));
        assertEquals(0, solution.solution("a", "ab"));
        assertEquals(2, solution.solution("catastrophic", "cat"));
        assertEquals(1, solution.solution("cbaltbla", "cat"));
        assertEquals(0, solution.solution("ТурбоФакер", "cat"));
        assertEquals(0, solution.solution("北京位於華北平原的西北边缘人文景观", "cat"));
        assertEquals(0, solution.solution("وضع ابنالنموذج الرياضي الومة الظواهر الملحوظة.", "cat"));
        assertEquals(0, solution.solution("Iñtërnâtiônàlizætiøn☃💪", "cat"));
        }
    }