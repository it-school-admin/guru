package su.itschool.guru.service.irtechimport.result;

import org.junit.jupiter.api.Test;
import su.itschool.guru.service.irtechimport.ImportResult;

import static org.junit.jupiter.api.Assertions.*;

class ClassesImportResultTest {
    @Test
    void getResult()
    {
        ImportResult importResult = new ClassesImportResult(10);
        assertEquals("Импортировано 10 классов" , importResult.getResultString());
    }

}