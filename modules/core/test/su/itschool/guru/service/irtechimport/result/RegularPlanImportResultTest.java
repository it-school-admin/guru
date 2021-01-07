package su.itschool.guru.service.irtechimport.result;

import org.junit.jupiter.api.Test;
import su.itschool.guru.service.irtechimport.ImportResult;

import static org.junit.jupiter.api.Assertions.*;

class RegularPlanImportResultTest {
    @Test
    void getResult()
    {
        ImportResult importResult = new RegularPlanImportResult(100);
        assertEquals("Импортирована информация о 100 элементах плана" , importResult.getResultString());
    }
}