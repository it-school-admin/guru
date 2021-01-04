package su.itschool.guru.service.irtechimport.result;

import org.junit.jupiter.api.Test;
import su.itschool.guru.service.irtechimport.ImportResult;

import static org.junit.jupiter.api.Assertions.*;

class SubjectImportResultTest {
    @Test
    void getResult()
    {
        ImportResult importResult = new SubjectImportResult(10);
        assertEquals("Ипортировано 10 записей о предметах" , importResult.getResultString());
    }
}