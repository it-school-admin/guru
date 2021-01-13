package su.itschool.guru.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelServiceResultTest {
    @Test
    void testResultAllisOk()
    {
        BulkCreationResult result = new BulkCreationResult();
        assertTrue(result.allIsOK());
    }

    @Test
    void testResultNotAllisOk()
    {
        BulkCreationResult result = new BulkCreationResult();
        result.addErrorResult("first");
        result.addErrorResult("second");
        result.addErrorResult("third");
        result.addErrorResult("first");
        assertFalse(result.allIsOK());
        assertEquals(4, result.getNamesWithProblems().size());
    }

    @Test
    void testResultException()
    {
        BulkCreationResult result = new BulkCreationResult();
        assertThrows(RuntimeException.class, ()->{result.getNamesWithProblems();});
    }


}