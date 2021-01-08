package su.itschool.guru.service.irtechimport.result;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomethingImportedResultTest {
    @Test
    void testIsImported(){
        SomethingImportedResult somethingImportedResult = new SomethingImportedResult("Текст до %0 текст после", "10");
        assertTrue(somethingImportedResult.isImported());
    }

    @Test
    void testResult(){
        SomethingImportedResult somethingImportedResult = new SomethingImportedResult("Текст до %0 текст после","10");
        assertEquals("Текст до 10 текст после",  somethingImportedResult.getResultString());
    }
}