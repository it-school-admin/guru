package su.itschool.guru.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelServiceResultTest {
    @Test
    void testResultAllisOk()
    {
        BulkCreationResult result = new BulkCreationResult();
        result.addResult("first", true);
        result.addResult("second", true);
        result.addResult("third", true);
        result.addResult("first", true);
        assertTrue(result.allIsOK());
    }

    @Test
    void testResultNotAllisOk()
    {
        BulkCreationResult result = new BulkCreationResult();
        result.addResult("first", true);
        result.addResult("second", false);
        result.addResult("third", false);
        result.addResult("first", true);
        assertFalse(result.allIsOK());
        assertEquals(2, result.getNamesWithProblems().size());
    }

    @Test
    void testResultException()
    {
        BulkCreationResult result = new BulkCreationResult();
        result.addResult("first", true);
        result.addResult("second", true);
        result.addResult("third", true);
        result.addResult("first", true);
        assertThrows(RuntimeException.class, ()->{result.getNamesWithProblems();});
    }


}